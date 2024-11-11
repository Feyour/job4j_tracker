package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int subjectCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                subjectCount++;
            }
        }

        return totalScore / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            int subjectCount = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                subjectCount++;
            }
            result.add(new Label(pupil.name(), totalScore / subjectCount));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> scores = new LinkedHashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.put(subject.name(), scores.getOrDefault(subject.name(), 0.0) + subject.score());
                counts.put(subject.name(), counts.getOrDefault(subject.name(), 0) + 1);
            }
        }
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            String subjectName = entry.getKey();
            Double totalScore = entry.getValue();
            Integer count = counts.get(subjectName);
            double averageScore = totalScore / count;
            result.add(new Label(subjectName, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            result.add(new Label(pupil.name(), totalScore));
        }
        result.sort(Label::compareTo);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        BiFunction<Double, Double, Double> function = (oldValue, newValue) -> oldValue - newValue;
        List<Label> result = new ArrayList<>();
        Map<String, Double> scores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.merge(subject.name(), (double) subject.score(), function);
            }
        }
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            String subjectName = entry.getKey();
            double averageScore = entry.getValue();
            result.add(new Label(subjectName, averageScore));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}