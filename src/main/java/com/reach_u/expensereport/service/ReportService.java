package com.reach_u.expensereport.service;

import com.reach_u.expensereport.model.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Database "replacement" for expense reports
 *
 ** Stores all reports in a list.
 *
 ** Adds methods for using report list / single report data.
 */
public class ReportService {
    private static List<Report> reports = new List<Report>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Report> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(Report report) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Report> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Report> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Report get(int i) {
            return null;
        }

        @Override
        public Report set(int i, Report report) {
            return null;
        }

        @Override
        public void add(int i, Report report) {

        }

        @Override
        public Report remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Report> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Report> listIterator(int i) {
            return null;
        }

        @Override
        public List<Report> subList(int i, int i1) {
            return null;
        }
    };

    public List list() {
        return reports;
    }

    public Report get(int reportId) {
        for (Report r : reports) {
            if (r.getReportId() == reportId) {
                return r;
            }
        }
        return null;
    }
}
