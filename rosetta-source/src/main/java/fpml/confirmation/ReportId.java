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
import fpml.confirmation.ReportId.ReportIdBuilder;
import fpml.confirmation.ReportId.ReportIdBuilderImpl;
import fpml.confirmation.ReportId.ReportIdImpl;
import fpml.confirmation.meta.ReportIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that can be used to hold an identifier for a report instance.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportId", builder=ReportId.ReportIdBuilderImpl.class, version="${project.version}")
public interface ReportId extends RosettaModelObject {

	ReportIdMeta metaData = new ReportIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportIdScheme();

	/*********************** Build Methods  ***********************/
	ReportId build();
	
	ReportId.ReportIdBuilder toBuilder();
	
	static ReportId.ReportIdBuilder builder() {
		return new ReportId.ReportIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportId> getType() {
		return ReportId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportIdScheme"), String.class, getReportIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportIdBuilder extends ReportId, RosettaModelObjectBuilder {
		ReportId.ReportIdBuilder setValue(String value);
		ReportId.ReportIdBuilder setReportIdScheme(String reportIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportIdScheme"), String.class, getReportIdScheme(), this);
		}
		

		ReportId.ReportIdBuilder prune();
	}

	/*********************** Immutable Implementation of ReportId  ***********************/
	class ReportIdImpl implements ReportId {
		private final String value;
		private final String reportIdScheme;
		
		protected ReportIdImpl(ReportId.ReportIdBuilder builder) {
			this.value = builder.getValue();
			this.reportIdScheme = builder.getReportIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportIdScheme")
		public String getReportIdScheme() {
			return reportIdScheme;
		}
		
		@Override
		public ReportId build() {
			return this;
		}
		
		@Override
		public ReportId.ReportIdBuilder toBuilder() {
			ReportId.ReportIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportId.ReportIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportIdScheme()).ifPresent(builder::setReportIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportIdScheme, _that.getReportIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportIdScheme != null ? reportIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportId {" +
				"value=" + this.value + ", " +
				"reportIdScheme=" + this.reportIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportId  ***********************/
	class ReportIdBuilderImpl implements ReportId.ReportIdBuilder {
	
		protected String value;
		protected String reportIdScheme;
	
		public ReportIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportIdScheme")
		public String getReportIdScheme() {
			return reportIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportId.ReportIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportIdScheme")
		public ReportId.ReportIdBuilder setReportIdScheme(String reportIdScheme) {
			this.reportIdScheme = reportIdScheme==null?null:reportIdScheme;
			return this;
		}
		
		@Override
		public ReportId build() {
			return new ReportId.ReportIdImpl(this);
		}
		
		@Override
		public ReportId.ReportIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportId.ReportIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportId.ReportIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportId.ReportIdBuilder o = (ReportId.ReportIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportIdScheme(), o.getReportIdScheme(), this::setReportIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportIdScheme, _that.getReportIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportIdScheme != null ? reportIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportIdBuilder {" +
				"value=" + this.value + ", " +
				"reportIdScheme=" + this.reportIdScheme +
			'}';
		}
	}
}
