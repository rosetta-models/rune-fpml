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
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.AllocationReportingStatus.AllocationReportingStatusBuilder;
import fpml.confirmation.AllocationReportingStatus.AllocationReportingStatusBuilderImpl;
import fpml.confirmation.AllocationReportingStatus.AllocationReportingStatusImpl;
import fpml.confirmation.meta.AllocationReportingStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Code that describes what type of allocation applies to the trade. Options include Unallocated, PreAllocation, PostAllocation.
 * @version ${project.version}
 */
@RosettaDataType(value="AllocationReportingStatus", builder=AllocationReportingStatus.AllocationReportingStatusBuilderImpl.class, version="${project.version}")
public interface AllocationReportingStatus extends RosettaModelObject {

	AllocationReportingStatusMeta metaData = new AllocationReportingStatusMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAllocationReportingStatusScheme();

	/*********************** Build Methods  ***********************/
	AllocationReportingStatus build();
	
	AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder();
	
	static AllocationReportingStatus.AllocationReportingStatusBuilder builder() {
		return new AllocationReportingStatus.AllocationReportingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationReportingStatus> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AllocationReportingStatus> getType() {
		return AllocationReportingStatus.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("allocationReportingStatusScheme"), String.class, getAllocationReportingStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationReportingStatusBuilder extends AllocationReportingStatus, RosettaModelObjectBuilder {
		AllocationReportingStatus.AllocationReportingStatusBuilder setValue(String value);
		AllocationReportingStatus.AllocationReportingStatusBuilder setAllocationReportingStatusScheme(String allocationReportingStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("allocationReportingStatusScheme"), String.class, getAllocationReportingStatusScheme(), this);
		}
		

		AllocationReportingStatus.AllocationReportingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationReportingStatus  ***********************/
	class AllocationReportingStatusImpl implements AllocationReportingStatus {
		private final String value;
		private final String allocationReportingStatusScheme;
		
		protected AllocationReportingStatusImpl(AllocationReportingStatus.AllocationReportingStatusBuilder builder) {
			this.value = builder.getValue();
			this.allocationReportingStatusScheme = builder.getAllocationReportingStatusScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationReportingStatusScheme")
		public String getAllocationReportingStatusScheme() {
			return allocationReportingStatusScheme;
		}
		
		@Override
		public AllocationReportingStatus build() {
			return this;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder() {
			AllocationReportingStatus.AllocationReportingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationReportingStatus.AllocationReportingStatusBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAllocationReportingStatusScheme()).ifPresent(builder::setAllocationReportingStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationReportingStatusScheme, _that.getAllocationReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationReportingStatusScheme != null ? allocationReportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationReportingStatus {" +
				"value=" + this.value + ", " +
				"allocationReportingStatusScheme=" + this.allocationReportingStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AllocationReportingStatus  ***********************/
	class AllocationReportingStatusBuilderImpl implements AllocationReportingStatus.AllocationReportingStatusBuilder {
	
		protected String value;
		protected String allocationReportingStatusScheme;
	
		public AllocationReportingStatusBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationReportingStatusScheme")
		public String getAllocationReportingStatusScheme() {
			return allocationReportingStatusScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AllocationReportingStatus.AllocationReportingStatusBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReportingStatusScheme")
		public AllocationReportingStatus.AllocationReportingStatusBuilder setAllocationReportingStatusScheme(String allocationReportingStatusScheme) {
			this.allocationReportingStatusScheme = allocationReportingStatusScheme==null?null:allocationReportingStatusScheme;
			return this;
		}
		
		@Override
		public AllocationReportingStatus build() {
			return new AllocationReportingStatus.AllocationReportingStatusImpl(this);
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAllocationReportingStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllocationReportingStatus.AllocationReportingStatusBuilder o = (AllocationReportingStatus.AllocationReportingStatusBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAllocationReportingStatusScheme(), o.getAllocationReportingStatusScheme(), this::setAllocationReportingStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationReportingStatusScheme, _that.getAllocationReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationReportingStatusScheme != null ? allocationReportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationReportingStatusBuilder {" +
				"value=" + this.value + ", " +
				"allocationReportingStatusScheme=" + this.allocationReportingStatusScheme +
			'}';
		}
	}
}
