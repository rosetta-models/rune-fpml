package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ReportId;
import fpml.confirmation.ReportSectionIdentification;
import fpml.confirmation.ReportSectionIdentification.ReportSectionIdentificationBuilder;
import fpml.confirmation.ReportSectionIdentification.ReportSectionIdentificationBuilderImpl;
import fpml.confirmation.ReportSectionIdentification.ReportSectionIdentificationImpl;
import fpml.confirmation.meta.ReportSectionIdentificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that allows the specific report and section to be identified.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportSectionIdentification", builder=ReportSectionIdentification.ReportSectionIdentificationBuilderImpl.class, version="${project.version}")
public interface ReportSectionIdentification extends RosettaModelObject {

	ReportSectionIdentificationMeta metaData = new ReportSectionIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An identifier for the specific instance of this report.
	 */
	ReportId getReportId();
	/**
	 * A strictly ascending sequential (gapless) numeric value that can be used to identify the section of a report.
	 */
	Integer getSectionNumber();

	/*********************** Build Methods  ***********************/
	ReportSectionIdentification build();
	
	ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder();
	
	static ReportSectionIdentification.ReportSectionIdentificationBuilder builder() {
		return new ReportSectionIdentification.ReportSectionIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportSectionIdentification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportSectionIdentification> getType() {
		return ReportSectionIdentification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportId"), processor, ReportId.class, getReportId());
		processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportSectionIdentificationBuilder extends ReportSectionIdentification, RosettaModelObjectBuilder {
		ReportId.ReportIdBuilder getOrCreateReportId();
		ReportId.ReportIdBuilder getReportId();
		ReportSectionIdentification.ReportSectionIdentificationBuilder setReportId(ReportId reportId);
		ReportSectionIdentification.ReportSectionIdentificationBuilder setSectionNumber(Integer sectionNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportId"), processor, ReportId.ReportIdBuilder.class, getReportId());
			processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
		}
		

		ReportSectionIdentification.ReportSectionIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportSectionIdentification  ***********************/
	class ReportSectionIdentificationImpl implements ReportSectionIdentification {
		private final ReportId reportId;
		private final Integer sectionNumber;
		
		protected ReportSectionIdentificationImpl(ReportSectionIdentification.ReportSectionIdentificationBuilder builder) {
			this.reportId = ofNullable(builder.getReportId()).map(f->f.build()).orElse(null);
			this.sectionNumber = builder.getSectionNumber();
		}
		
		@Override
		@RosettaAttribute("reportId")
		public ReportId getReportId() {
			return reportId;
		}
		
		@Override
		@RosettaAttribute("sectionNumber")
		public Integer getSectionNumber() {
			return sectionNumber;
		}
		
		@Override
		public ReportSectionIdentification build() {
			return this;
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder() {
			ReportSectionIdentification.ReportSectionIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportSectionIdentification.ReportSectionIdentificationBuilder builder) {
			ofNullable(getReportId()).ifPresent(builder::setReportId);
			ofNullable(getSectionNumber()).ifPresent(builder::setSectionNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentification _that = getType().cast(o);
		
			if (!Objects.equals(reportId, _that.getReportId())) return false;
			if (!Objects.equals(sectionNumber, _that.getSectionNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportId != null ? reportId.hashCode() : 0);
			_result = 31 * _result + (sectionNumber != null ? sectionNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentification {" +
				"reportId=" + this.reportId + ", " +
				"sectionNumber=" + this.sectionNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportSectionIdentification  ***********************/
	class ReportSectionIdentificationBuilderImpl implements ReportSectionIdentification.ReportSectionIdentificationBuilder {
	
		protected ReportId.ReportIdBuilder reportId;
		protected Integer sectionNumber;
	
		public ReportSectionIdentificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reportId")
		public ReportId.ReportIdBuilder getReportId() {
			return reportId;
		}
		
		@Override
		public ReportId.ReportIdBuilder getOrCreateReportId() {
			ReportId.ReportIdBuilder result;
			if (reportId!=null) {
				result = reportId;
			}
			else {
				result = reportId = ReportId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sectionNumber")
		public Integer getSectionNumber() {
			return sectionNumber;
		}
		
		@Override
		@RosettaAttribute("reportId")
		public ReportSectionIdentification.ReportSectionIdentificationBuilder setReportId(ReportId reportId) {
			this.reportId = reportId==null?null:reportId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sectionNumber")
		public ReportSectionIdentification.ReportSectionIdentificationBuilder setSectionNumber(Integer sectionNumber) {
			this.sectionNumber = sectionNumber==null?null:sectionNumber;
			return this;
		}
		
		@Override
		public ReportSectionIdentification build() {
			return new ReportSectionIdentification.ReportSectionIdentificationImpl(this);
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder prune() {
			if (reportId!=null && !reportId.prune().hasData()) reportId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportId()!=null && getReportId().hasData()) return true;
			if (getSectionNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportSectionIdentification.ReportSectionIdentificationBuilder o = (ReportSectionIdentification.ReportSectionIdentificationBuilder) other;
			
			merger.mergeRosetta(getReportId(), o.getReportId(), this::setReportId);
			
			merger.mergeBasic(getSectionNumber(), o.getSectionNumber(), this::setSectionNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentification _that = getType().cast(o);
		
			if (!Objects.equals(reportId, _that.getReportId())) return false;
			if (!Objects.equals(sectionNumber, _that.getSectionNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportId != null ? reportId.hashCode() : 0);
			_result = 31 * _result + (sectionNumber != null ? sectionNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentificationBuilder {" +
				"reportId=" + this.reportId + ", " +
				"sectionNumber=" + this.sectionNumber +
			'}';
		}
	}
}
