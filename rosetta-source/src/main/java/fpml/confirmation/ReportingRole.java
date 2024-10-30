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
import fpml.confirmation.ReportingRole;
import fpml.confirmation.ReportingRole.ReportingRoleBuilder;
import fpml.confirmation.ReportingRole.ReportingRoleBuilderImpl;
import fpml.confirmation.ReportingRole.ReportingRoleImpl;
import fpml.confirmation.meta.ReportingRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type containing a code representing the role of a party in a report, e.g. the originator, the recipient, the counterparty, etc. This is used to clarify which participant&#39;s information is being reported.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReportingRole", builder=ReportingRole.ReportingRoleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReportingRole extends RosettaModelObject {

	ReportingRoleMeta metaData = new ReportingRoleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReportingRoleScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	ReportingRole build();
	
	ReportingRole.ReportingRoleBuilder toBuilder();
	
	static ReportingRole.ReportingRoleBuilder builder() {
		return new ReportingRole.ReportingRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRole> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRole> getType() {
		return ReportingRole.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingRoleScheme"), String.class, getReportingRoleScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRoleBuilder extends ReportingRole, RosettaModelObjectBuilder {
		ReportingRole.ReportingRoleBuilder setValue(String value);
		ReportingRole.ReportingRoleBuilder setReportingRoleScheme(String reportingRoleScheme);
		ReportingRole.ReportingRoleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingRoleScheme"), String.class, getReportingRoleScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ReportingRole.ReportingRoleBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRole  ***********************/
	class ReportingRoleImpl implements ReportingRole {
		private final String value;
		private final String reportingRoleScheme;
		private final String id;
		
		protected ReportingRoleImpl(ReportingRole.ReportingRoleBuilder builder) {
			this.value = builder.getValue();
			this.reportingRoleScheme = builder.getReportingRoleScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingRoleScheme")
		public String getReportingRoleScheme() {
			return reportingRoleScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ReportingRole build() {
			return this;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder toBuilder() {
			ReportingRole.ReportingRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRole.ReportingRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingRoleScheme()).ifPresent(builder::setReportingRoleScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingRoleScheme, _that.getReportingRoleScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingRoleScheme != null ? reportingRoleScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRole {" +
				"value=" + this.value + ", " +
				"reportingRoleScheme=" + this.reportingRoleScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRole  ***********************/
	class ReportingRoleBuilderImpl implements ReportingRole.ReportingRoleBuilder {
	
		protected String value;
		protected String reportingRoleScheme;
		protected String id;
	
		public ReportingRoleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingRoleScheme")
		public String getReportingRoleScheme() {
			return reportingRoleScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReportingRole.ReportingRoleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reportingRoleScheme")
		public ReportingRole.ReportingRoleBuilder setReportingRoleScheme(String reportingRoleScheme) {
			this.reportingRoleScheme = reportingRoleScheme==null?null:reportingRoleScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReportingRole.ReportingRoleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ReportingRole build() {
			return new ReportingRole.ReportingRoleImpl(this);
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRole.ReportingRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingRoleScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRole.ReportingRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRole.ReportingRoleBuilder o = (ReportingRole.ReportingRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingRoleScheme(), o.getReportingRoleScheme(), this::setReportingRoleScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingRoleScheme, _that.getReportingRoleScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingRoleScheme != null ? reportingRoleScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRoleBuilder {" +
				"value=" + this.value + ", " +
				"reportingRoleScheme=" + this.reportingRoleScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
