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
import fpml.confirmation.LoanAllocationSettlementTaskType;
import fpml.confirmation.LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder;
import fpml.confirmation.LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeImpl;
import fpml.confirmation.meta.LoanAllocationSettlementTaskTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure used to uniquely identify a settlement task type within a syndicated loan structure.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationSettlementTaskType", builder=LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl.class, version="${project.version}")
public interface LoanAllocationSettlementTaskType extends RosettaModelObject {

	LoanAllocationSettlementTaskTypeMeta metaData = new LoanAllocationSettlementTaskTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAllocationSettlementTaskTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementTaskType build();
	
	LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder();
	
	static LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder() {
		return new LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementTaskType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementTaskType> getType() {
		return LoanAllocationSettlementTaskType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("allocationSettlementTaskTypeScheme"), String.class, getAllocationSettlementTaskTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementTaskTypeBuilder extends LoanAllocationSettlementTaskType, RosettaModelObjectBuilder {
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setValue(String value);
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setAllocationSettlementTaskTypeScheme(String allocationSettlementTaskTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("allocationSettlementTaskTypeScheme"), String.class, getAllocationSettlementTaskTypeScheme(), this);
		}
		

		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementTaskType  ***********************/
	class LoanAllocationSettlementTaskTypeImpl implements LoanAllocationSettlementTaskType {
		private final String value;
		private final String allocationSettlementTaskTypeScheme;
		
		protected LoanAllocationSettlementTaskTypeImpl(LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder) {
			this.value = builder.getValue();
			this.allocationSettlementTaskTypeScheme = builder.getAllocationSettlementTaskTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		public String getAllocationSettlementTaskTypeScheme() {
			return allocationSettlementTaskTypeScheme;
		}
		
		@Override
		public LoanAllocationSettlementTaskType build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder() {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAllocationSettlementTaskTypeScheme()).ifPresent(builder::setAllocationSettlementTaskTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationSettlementTaskTypeScheme, _that.getAllocationSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationSettlementTaskTypeScheme != null ? allocationSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskType {" +
				"value=" + this.value + ", " +
				"allocationSettlementTaskTypeScheme=" + this.allocationSettlementTaskTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementTaskType  ***********************/
	class LoanAllocationSettlementTaskTypeBuilderImpl implements LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder {
	
		protected String value;
		protected String allocationSettlementTaskTypeScheme;
	
		public LoanAllocationSettlementTaskTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		public String getAllocationSettlementTaskTypeScheme() {
			return allocationSettlementTaskTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setAllocationSettlementTaskTypeScheme(String allocationSettlementTaskTypeScheme) {
			this.allocationSettlementTaskTypeScheme = allocationSettlementTaskTypeScheme==null?null:allocationSettlementTaskTypeScheme;
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTaskType build() {
			return new LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAllocationSettlementTaskTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder o = (LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAllocationSettlementTaskTypeScheme(), o.getAllocationSettlementTaskTypeScheme(), this::setAllocationSettlementTaskTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationSettlementTaskTypeScheme, _that.getAllocationSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationSettlementTaskTypeScheme != null ? allocationSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskTypeBuilder {" +
				"value=" + this.value + ", " +
				"allocationSettlementTaskTypeScheme=" + this.allocationSettlementTaskTypeScheme +
			'}';
		}
	}
}
