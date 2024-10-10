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
import fpml.confirmation.BusinessUnitRole;
import fpml.confirmation.BusinessUnitRole.BusinessUnitRoleBuilder;
import fpml.confirmation.BusinessUnitRole.BusinessUnitRoleBuilderImpl;
import fpml.confirmation.BusinessUnitRole.BusinessUnitRoleImpl;
import fpml.confirmation.meta.BusinessUnitRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a role played by a unit in one or more transactions. Examples include roles such as Trader, Collateral, Confirmation, Settlement, etc. This can be extended to provide custom roles.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessUnitRole", builder=BusinessUnitRole.BusinessUnitRoleBuilderImpl.class, version="${project.version}")
public interface BusinessUnitRole extends RosettaModelObject {

	BusinessUnitRoleMeta metaData = new BusinessUnitRoleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getUnitRoleScheme();

	/*********************** Build Methods  ***********************/
	BusinessUnitRole build();
	
	BusinessUnitRole.BusinessUnitRoleBuilder toBuilder();
	
	static BusinessUnitRole.BusinessUnitRoleBuilder builder() {
		return new BusinessUnitRole.BusinessUnitRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessUnitRole> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessUnitRole> getType() {
		return BusinessUnitRole.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("unitRoleScheme"), String.class, getUnitRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessUnitRoleBuilder extends BusinessUnitRole, RosettaModelObjectBuilder {
		BusinessUnitRole.BusinessUnitRoleBuilder setValue(String value);
		BusinessUnitRole.BusinessUnitRoleBuilder setUnitRoleScheme(String unitRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("unitRoleScheme"), String.class, getUnitRoleScheme(), this);
		}
		

		BusinessUnitRole.BusinessUnitRoleBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessUnitRole  ***********************/
	class BusinessUnitRoleImpl implements BusinessUnitRole {
		private final String value;
		private final String unitRoleScheme;
		
		protected BusinessUnitRoleImpl(BusinessUnitRole.BusinessUnitRoleBuilder builder) {
			this.value = builder.getValue();
			this.unitRoleScheme = builder.getUnitRoleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("unitRoleScheme")
		public String getUnitRoleScheme() {
			return unitRoleScheme;
		}
		
		@Override
		public BusinessUnitRole build() {
			return this;
		}
		
		@Override
		public BusinessUnitRole.BusinessUnitRoleBuilder toBuilder() {
			BusinessUnitRole.BusinessUnitRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessUnitRole.BusinessUnitRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getUnitRoleScheme()).ifPresent(builder::setUnitRoleScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnitRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(unitRoleScheme, _that.getUnitRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (unitRoleScheme != null ? unitRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnitRole {" +
				"value=" + this.value + ", " +
				"unitRoleScheme=" + this.unitRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessUnitRole  ***********************/
	class BusinessUnitRoleBuilderImpl implements BusinessUnitRole.BusinessUnitRoleBuilder {
	
		protected String value;
		protected String unitRoleScheme;
	
		public BusinessUnitRoleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("unitRoleScheme")
		public String getUnitRoleScheme() {
			return unitRoleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public BusinessUnitRole.BusinessUnitRoleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("unitRoleScheme")
		public BusinessUnitRole.BusinessUnitRoleBuilder setUnitRoleScheme(String unitRoleScheme) {
			this.unitRoleScheme = unitRoleScheme==null?null:unitRoleScheme;
			return this;
		}
		
		@Override
		public BusinessUnitRole build() {
			return new BusinessUnitRole.BusinessUnitRoleImpl(this);
		}
		
		@Override
		public BusinessUnitRole.BusinessUnitRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnitRole.BusinessUnitRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getUnitRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnitRole.BusinessUnitRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessUnitRole.BusinessUnitRoleBuilder o = (BusinessUnitRole.BusinessUnitRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getUnitRoleScheme(), o.getUnitRoleScheme(), this::setUnitRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnitRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(unitRoleScheme, _that.getUnitRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (unitRoleScheme != null ? unitRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnitRoleBuilder {" +
				"value=" + this.value + ", " +
				"unitRoleScheme=" + this.unitRoleScheme +
			'}';
		}
	}
}
