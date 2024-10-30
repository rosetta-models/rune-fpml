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
import fpml.confirmation.ReportingLevel;
import fpml.confirmation.ReportingLevel.ReportingLevelBuilder;
import fpml.confirmation.ReportingLevel.ReportingLevelBuilderImpl;
import fpml.confirmation.ReportingLevel.ReportingLevelImpl;
import fpml.confirmation.meta.ReportingLevelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type containing a code representing the level at which this is reported (e.g. Trade or Position)
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReportingLevel", builder=ReportingLevel.ReportingLevelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReportingLevel extends RosettaModelObject {

	ReportingLevelMeta metaData = new ReportingLevelMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingLevelScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	ReportingLevel build();
	
	ReportingLevel.ReportingLevelBuilder toBuilder();
	
	static ReportingLevel.ReportingLevelBuilder builder() {
		return new ReportingLevel.ReportingLevelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingLevel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingLevel> getType() {
		return ReportingLevel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingLevelScheme"), String.class, getReportingLevelScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingLevelBuilder extends ReportingLevel, RosettaModelObjectBuilder {
		ReportingLevel.ReportingLevelBuilder setValue(String value);
		ReportingLevel.ReportingLevelBuilder setReportingLevelScheme(String reportingLevelScheme);
		ReportingLevel.ReportingLevelBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingLevelScheme"), String.class, getReportingLevelScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ReportingLevel.ReportingLevelBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingLevel  ***********************/
	class ReportingLevelImpl implements ReportingLevel {
		private final String value;
		private final String reportingLevelScheme;
		private final String id;
		
		protected ReportingLevelImpl(ReportingLevel.ReportingLevelBuilder builder) {
			this.value = builder.getValue();
			this.reportingLevelScheme = builder.getReportingLevelScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingLevelScheme")
		public String getReportingLevelScheme() {
			return reportingLevelScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ReportingLevel build() {
			return this;
		}
		
		@Override
		public ReportingLevel.ReportingLevelBuilder toBuilder() {
			ReportingLevel.ReportingLevelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingLevel.ReportingLevelBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingLevelScheme()).ifPresent(builder::setReportingLevelScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingLevel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingLevelScheme, _that.getReportingLevelScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingLevelScheme != null ? reportingLevelScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingLevel {" +
				"value=" + this.value + ", " +
				"reportingLevelScheme=" + this.reportingLevelScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingLevel  ***********************/
	class ReportingLevelBuilderImpl implements ReportingLevel.ReportingLevelBuilder {
	
		protected String value;
		protected String reportingLevelScheme;
		protected String id;
	
		public ReportingLevelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingLevelScheme")
		public String getReportingLevelScheme() {
			return reportingLevelScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingLevel.ReportingLevelBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingLevelScheme")
		public ReportingLevel.ReportingLevelBuilder setReportingLevelScheme(String reportingLevelScheme) {
			this.reportingLevelScheme = reportingLevelScheme==null?null:reportingLevelScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReportingLevel.ReportingLevelBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ReportingLevel build() {
			return new ReportingLevel.ReportingLevelImpl(this);
		}
		
		@Override
		public ReportingLevel.ReportingLevelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingLevel.ReportingLevelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingLevelScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingLevel.ReportingLevelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingLevel.ReportingLevelBuilder o = (ReportingLevel.ReportingLevelBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingLevelScheme(), o.getReportingLevelScheme(), this::setReportingLevelScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingLevel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingLevelScheme, _that.getReportingLevelScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingLevelScheme != null ? reportingLevelScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingLevelBuilder {" +
				"value=" + this.value + ", " +
				"reportingLevelScheme=" + this.reportingLevelScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
