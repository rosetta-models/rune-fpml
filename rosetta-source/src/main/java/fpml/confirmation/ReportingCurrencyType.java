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
import fpml.confirmation.ReportingCurrencyType;
import fpml.confirmation.ReportingCurrencyType.ReportingCurrencyTypeBuilder;
import fpml.confirmation.ReportingCurrencyType.ReportingCurrencyTypeBuilderImpl;
import fpml.confirmation.ReportingCurrencyType.ReportingCurrencyTypeImpl;
import fpml.confirmation.meta.ReportingCurrencyTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the type of currency that was used to report the value of an asset. For example, this could contain values like SettlementCurrency, QuoteCurrency, UnitCurrency, etc.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingCurrencyType", builder=ReportingCurrencyType.ReportingCurrencyTypeBuilderImpl.class, version="${project.version}")
public interface ReportingCurrencyType extends RosettaModelObject {

	ReportingCurrencyTypeMeta metaData = new ReportingCurrencyTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingCurrencyTypeScheme();

	/*********************** Build Methods  ***********************/
	ReportingCurrencyType build();
	
	ReportingCurrencyType.ReportingCurrencyTypeBuilder toBuilder();
	
	static ReportingCurrencyType.ReportingCurrencyTypeBuilder builder() {
		return new ReportingCurrencyType.ReportingCurrencyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingCurrencyType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingCurrencyType> getType() {
		return ReportingCurrencyType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingCurrencyTypeScheme"), String.class, getReportingCurrencyTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingCurrencyTypeBuilder extends ReportingCurrencyType, RosettaModelObjectBuilder {
		ReportingCurrencyType.ReportingCurrencyTypeBuilder setValue(String value);
		ReportingCurrencyType.ReportingCurrencyTypeBuilder setReportingCurrencyTypeScheme(String reportingCurrencyTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingCurrencyTypeScheme"), String.class, getReportingCurrencyTypeScheme(), this);
		}
		

		ReportingCurrencyType.ReportingCurrencyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingCurrencyType  ***********************/
	class ReportingCurrencyTypeImpl implements ReportingCurrencyType {
		private final String value;
		private final String reportingCurrencyTypeScheme;
		
		protected ReportingCurrencyTypeImpl(ReportingCurrencyType.ReportingCurrencyTypeBuilder builder) {
			this.value = builder.getValue();
			this.reportingCurrencyTypeScheme = builder.getReportingCurrencyTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingCurrencyTypeScheme")
		public String getReportingCurrencyTypeScheme() {
			return reportingCurrencyTypeScheme;
		}
		
		@Override
		public ReportingCurrencyType build() {
			return this;
		}
		
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder toBuilder() {
			ReportingCurrencyType.ReportingCurrencyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingCurrencyType.ReportingCurrencyTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingCurrencyTypeScheme()).ifPresent(builder::setReportingCurrencyTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingCurrencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingCurrencyTypeScheme, _that.getReportingCurrencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingCurrencyTypeScheme != null ? reportingCurrencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingCurrencyType {" +
				"value=" + this.value + ", " +
				"reportingCurrencyTypeScheme=" + this.reportingCurrencyTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingCurrencyType  ***********************/
	class ReportingCurrencyTypeBuilderImpl implements ReportingCurrencyType.ReportingCurrencyTypeBuilder {
	
		protected String value;
		protected String reportingCurrencyTypeScheme;
	
		public ReportingCurrencyTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingCurrencyTypeScheme")
		public String getReportingCurrencyTypeScheme() {
			return reportingCurrencyTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingCurrencyTypeScheme")
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder setReportingCurrencyTypeScheme(String reportingCurrencyTypeScheme) {
			this.reportingCurrencyTypeScheme = reportingCurrencyTypeScheme==null?null:reportingCurrencyTypeScheme;
			return this;
		}
		
		@Override
		public ReportingCurrencyType build() {
			return new ReportingCurrencyType.ReportingCurrencyTypeImpl(this);
		}
		
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingCurrencyTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingCurrencyType.ReportingCurrencyTypeBuilder o = (ReportingCurrencyType.ReportingCurrencyTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingCurrencyTypeScheme(), o.getReportingCurrencyTypeScheme(), this::setReportingCurrencyTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingCurrencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingCurrencyTypeScheme, _that.getReportingCurrencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingCurrencyTypeScheme != null ? reportingCurrencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingCurrencyTypeBuilder {" +
				"value=" + this.value + ", " +
				"reportingCurrencyTypeScheme=" + this.reportingCurrencyTypeScheme +
			'}';
		}
	}
}
