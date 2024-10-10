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
import fpml.confirmation.ReportingBoolean;
import fpml.confirmation.ReportingBoolean.ReportingBooleanBuilder;
import fpml.confirmation.ReportingBoolean.ReportingBooleanBuilderImpl;
import fpml.confirmation.ReportingBoolean.ReportingBooleanImpl;
import fpml.confirmation.meta.ReportingBooleanMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * How a Boolean value is to be reported for this regulator. Typically &quot;true&quot; or &quot;false&quot;, but for ESMA &quot;X&quot; is also allowed, to indicate not supplied.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingBoolean", builder=ReportingBoolean.ReportingBooleanBuilderImpl.class, version="${project.version}")
public interface ReportingBoolean extends RosettaModelObject {

	ReportingBooleanMeta metaData = new ReportingBooleanMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingBooleanScheme();

	/*********************** Build Methods  ***********************/
	ReportingBoolean build();
	
	ReportingBoolean.ReportingBooleanBuilder toBuilder();
	
	static ReportingBoolean.ReportingBooleanBuilder builder() {
		return new ReportingBoolean.ReportingBooleanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingBoolean> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingBoolean> getType() {
		return ReportingBoolean.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingBooleanScheme"), String.class, getReportingBooleanScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingBooleanBuilder extends ReportingBoolean, RosettaModelObjectBuilder {
		ReportingBoolean.ReportingBooleanBuilder setValue(String value);
		ReportingBoolean.ReportingBooleanBuilder setReportingBooleanScheme(String reportingBooleanScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingBooleanScheme"), String.class, getReportingBooleanScheme(), this);
		}
		

		ReportingBoolean.ReportingBooleanBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingBoolean  ***********************/
	class ReportingBooleanImpl implements ReportingBoolean {
		private final String value;
		private final String reportingBooleanScheme;
		
		protected ReportingBooleanImpl(ReportingBoolean.ReportingBooleanBuilder builder) {
			this.value = builder.getValue();
			this.reportingBooleanScheme = builder.getReportingBooleanScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingBooleanScheme")
		public String getReportingBooleanScheme() {
			return reportingBooleanScheme;
		}
		
		@Override
		public ReportingBoolean build() {
			return this;
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder toBuilder() {
			ReportingBoolean.ReportingBooleanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingBoolean.ReportingBooleanBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingBooleanScheme()).ifPresent(builder::setReportingBooleanScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingBoolean _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingBooleanScheme, _that.getReportingBooleanScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingBooleanScheme != null ? reportingBooleanScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingBoolean {" +
				"value=" + this.value + ", " +
				"reportingBooleanScheme=" + this.reportingBooleanScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingBoolean  ***********************/
	class ReportingBooleanBuilderImpl implements ReportingBoolean.ReportingBooleanBuilder {
	
		protected String value;
		protected String reportingBooleanScheme;
	
		public ReportingBooleanBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingBooleanScheme")
		public String getReportingBooleanScheme() {
			return reportingBooleanScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingBoolean.ReportingBooleanBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingBooleanScheme")
		public ReportingBoolean.ReportingBooleanBuilder setReportingBooleanScheme(String reportingBooleanScheme) {
			this.reportingBooleanScheme = reportingBooleanScheme==null?null:reportingBooleanScheme;
			return this;
		}
		
		@Override
		public ReportingBoolean build() {
			return new ReportingBoolean.ReportingBooleanImpl(this);
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingBooleanScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingBoolean.ReportingBooleanBuilder o = (ReportingBoolean.ReportingBooleanBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingBooleanScheme(), o.getReportingBooleanScheme(), this::setReportingBooleanScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingBoolean _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingBooleanScheme, _that.getReportingBooleanScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingBooleanScheme != null ? reportingBooleanScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingBooleanBuilder {" +
				"value=" + this.value + ", " +
				"reportingBooleanScheme=" + this.reportingBooleanScheme +
			'}';
		}
	}
}
