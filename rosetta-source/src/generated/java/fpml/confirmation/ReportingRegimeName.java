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
import fpml.confirmation.ReportingRegimeName;
import fpml.confirmation.ReportingRegimeName.ReportingRegimeNameBuilder;
import fpml.confirmation.ReportingRegimeName.ReportingRegimeNameBuilderImpl;
import fpml.confirmation.ReportingRegimeName.ReportingRegimeNameImpl;
import fpml.confirmation.meta.ReportingRegimeNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An identifier of an reporting regime or format used for regulatory reporting, for example DoddFrankAct, MiFID, HongKongOTCDRepository, etc.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingRegimeName", builder=ReportingRegimeName.ReportingRegimeNameBuilderImpl.class, version="${project.version}")
public interface ReportingRegimeName extends RosettaModelObject {

	ReportingRegimeNameMeta metaData = new ReportingRegimeNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingRegimeNameScheme();

	/*********************** Build Methods  ***********************/
	ReportingRegimeName build();
	
	ReportingRegimeName.ReportingRegimeNameBuilder toBuilder();
	
	static ReportingRegimeName.ReportingRegimeNameBuilder builder() {
		return new ReportingRegimeName.ReportingRegimeNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegimeName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRegimeName> getType() {
		return ReportingRegimeName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingRegimeNameScheme"), String.class, getReportingRegimeNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeNameBuilder extends ReportingRegimeName, RosettaModelObjectBuilder {
		ReportingRegimeName.ReportingRegimeNameBuilder setValue(String value);
		ReportingRegimeName.ReportingRegimeNameBuilder setReportingRegimeNameScheme(String reportingRegimeNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingRegimeNameScheme"), String.class, getReportingRegimeNameScheme(), this);
		}
		

		ReportingRegimeName.ReportingRegimeNameBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRegimeName  ***********************/
	class ReportingRegimeNameImpl implements ReportingRegimeName {
		private final String value;
		private final String reportingRegimeNameScheme;
		
		protected ReportingRegimeNameImpl(ReportingRegimeName.ReportingRegimeNameBuilder builder) {
			this.value = builder.getValue();
			this.reportingRegimeNameScheme = builder.getReportingRegimeNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeNameScheme")
		public String getReportingRegimeNameScheme() {
			return reportingRegimeNameScheme;
		}
		
		@Override
		public ReportingRegimeName build() {
			return this;
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder toBuilder() {
			ReportingRegimeName.ReportingRegimeNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegimeName.ReportingRegimeNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingRegimeNameScheme()).ifPresent(builder::setReportingRegimeNameScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingRegimeNameScheme, _that.getReportingRegimeNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingRegimeNameScheme != null ? reportingRegimeNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeName {" +
				"value=" + this.value + ", " +
				"reportingRegimeNameScheme=" + this.reportingRegimeNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegimeName  ***********************/
	class ReportingRegimeNameBuilderImpl implements ReportingRegimeName.ReportingRegimeNameBuilder {
	
		protected String value;
		protected String reportingRegimeNameScheme;
	
		public ReportingRegimeNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeNameScheme")
		public String getReportingRegimeNameScheme() {
			return reportingRegimeNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingRegimeName.ReportingRegimeNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingRegimeNameScheme")
		public ReportingRegimeName.ReportingRegimeNameBuilder setReportingRegimeNameScheme(String reportingRegimeNameScheme) {
			this.reportingRegimeNameScheme = reportingRegimeNameScheme==null?null:reportingRegimeNameScheme;
			return this;
		}
		
		@Override
		public ReportingRegimeName build() {
			return new ReportingRegimeName.ReportingRegimeNameImpl(this);
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingRegimeNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegimeName.ReportingRegimeNameBuilder o = (ReportingRegimeName.ReportingRegimeNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingRegimeNameScheme(), o.getReportingRegimeNameScheme(), this::setReportingRegimeNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingRegimeNameScheme, _that.getReportingRegimeNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingRegimeNameScheme != null ? reportingRegimeNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeNameBuilder {" +
				"value=" + this.value + ", " +
				"reportingRegimeNameScheme=" + this.reportingRegimeNameScheme +
			'}';
		}
	}
}
