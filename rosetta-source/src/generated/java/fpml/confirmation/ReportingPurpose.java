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
import fpml.confirmation.ReportingPurpose;
import fpml.confirmation.ReportingPurpose.ReportingPurposeBuilder;
import fpml.confirmation.ReportingPurpose.ReportingPurposeBuilderImpl;
import fpml.confirmation.ReportingPurpose.ReportingPurposeImpl;
import fpml.confirmation.meta.ReportingPurposeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A value that explains the reason or purpose that information is being reported. Examples might include RealTimePublic reporting, PrimaryEconomicTerms reporting, Confirmation reporting, or Snapshot reporting.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingPurpose", builder=ReportingPurpose.ReportingPurposeBuilderImpl.class, version="${project.version}")
public interface ReportingPurpose extends RosettaModelObject {

	ReportingPurposeMeta metaData = new ReportingPurposeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingPurposeScheme();

	/*********************** Build Methods  ***********************/
	ReportingPurpose build();
	
	ReportingPurpose.ReportingPurposeBuilder toBuilder();
	
	static ReportingPurpose.ReportingPurposeBuilder builder() {
		return new ReportingPurpose.ReportingPurposeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingPurpose> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingPurpose> getType() {
		return ReportingPurpose.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingPurposeScheme"), String.class, getReportingPurposeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingPurposeBuilder extends ReportingPurpose, RosettaModelObjectBuilder {
		ReportingPurpose.ReportingPurposeBuilder setValue(String value);
		ReportingPurpose.ReportingPurposeBuilder setReportingPurposeScheme(String reportingPurposeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingPurposeScheme"), String.class, getReportingPurposeScheme(), this);
		}
		

		ReportingPurpose.ReportingPurposeBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingPurpose  ***********************/
	class ReportingPurposeImpl implements ReportingPurpose {
		private final String value;
		private final String reportingPurposeScheme;
		
		protected ReportingPurposeImpl(ReportingPurpose.ReportingPurposeBuilder builder) {
			this.value = builder.getValue();
			this.reportingPurposeScheme = builder.getReportingPurposeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingPurposeScheme")
		public String getReportingPurposeScheme() {
			return reportingPurposeScheme;
		}
		
		@Override
		public ReportingPurpose build() {
			return this;
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder toBuilder() {
			ReportingPurpose.ReportingPurposeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingPurpose.ReportingPurposeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingPurposeScheme()).ifPresent(builder::setReportingPurposeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingPurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingPurposeScheme, _that.getReportingPurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingPurposeScheme != null ? reportingPurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingPurpose {" +
				"value=" + this.value + ", " +
				"reportingPurposeScheme=" + this.reportingPurposeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingPurpose  ***********************/
	class ReportingPurposeBuilderImpl implements ReportingPurpose.ReportingPurposeBuilder {
	
		protected String value;
		protected String reportingPurposeScheme;
	
		public ReportingPurposeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingPurposeScheme")
		public String getReportingPurposeScheme() {
			return reportingPurposeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingPurpose.ReportingPurposeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingPurposeScheme")
		public ReportingPurpose.ReportingPurposeBuilder setReportingPurposeScheme(String reportingPurposeScheme) {
			this.reportingPurposeScheme = reportingPurposeScheme==null?null:reportingPurposeScheme;
			return this;
		}
		
		@Override
		public ReportingPurpose build() {
			return new ReportingPurpose.ReportingPurposeImpl(this);
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingPurpose.ReportingPurposeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingPurposeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingPurpose.ReportingPurposeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingPurpose.ReportingPurposeBuilder o = (ReportingPurpose.ReportingPurposeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingPurposeScheme(), o.getReportingPurposeScheme(), this::setReportingPurposeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingPurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingPurposeScheme, _that.getReportingPurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingPurposeScheme != null ? reportingPurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingPurposeBuilder {" +
				"value=" + this.value + ", " +
				"reportingPurposeScheme=" + this.reportingPurposeScheme +
			'}';
		}
	}
}
