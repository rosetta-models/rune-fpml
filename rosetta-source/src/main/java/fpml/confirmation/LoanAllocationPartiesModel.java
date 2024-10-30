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
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder;
import fpml.confirmation.LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilderImpl;
import fpml.confirmation.LoanAllocationPartiesModel.LoanAllocationPartiesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.LoanAllocationPartiesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains the main parties involved in a loan allocation situation.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanAllocationPartiesModel", builder=LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanAllocationPartiesModel extends RosettaModelObject {

	LoanAllocationPartiesModelMeta metaData = new LoanAllocationPartiesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the party responsible for the allocation.
	 */
	PartyReference getOriginalPartyReference();
	/**
	 * A reference to the party that has been allocated to.
	 */
	PartyReference getAllocatedPartyReference();

	/*********************** Build Methods  ***********************/
	LoanAllocationPartiesModel build();
	
	LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder toBuilder();
	
	static LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder builder() {
		return new LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationPartiesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationPartiesModel> getType() {
		return LoanAllocationPartiesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originalPartyReference"), processor, PartyReference.class, getOriginalPartyReference());
		processRosetta(path.newSubPath("allocatedPartyReference"), processor, PartyReference.class, getAllocatedPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationPartiesModelBuilder extends LoanAllocationPartiesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOriginalPartyReference();
		PartyReference.PartyReferenceBuilder getOriginalPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAllocatedPartyReference();
		PartyReference.PartyReferenceBuilder getAllocatedPartyReference();
		LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder setOriginalPartyReference(PartyReference originalPartyReference);
		LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder setAllocatedPartyReference(PartyReference allocatedPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originalPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getOriginalPartyReference());
			processRosetta(path.newSubPath("allocatedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAllocatedPartyReference());
		}
		

		LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationPartiesModel  ***********************/
	class LoanAllocationPartiesModelImpl implements LoanAllocationPartiesModel {
		private final PartyReference originalPartyReference;
		private final PartyReference allocatedPartyReference;
		
		protected LoanAllocationPartiesModelImpl(LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder builder) {
			this.originalPartyReference = ofNullable(builder.getOriginalPartyReference()).map(f->f.build()).orElse(null);
			this.allocatedPartyReference = ofNullable(builder.getAllocatedPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalPartyReference")
		public PartyReference getOriginalPartyReference() {
			return originalPartyReference;
		}
		
		@Override
		@RosettaAttribute("allocatedPartyReference")
		public PartyReference getAllocatedPartyReference() {
			return allocatedPartyReference;
		}
		
		@Override
		public LoanAllocationPartiesModel build() {
			return this;
		}
		
		@Override
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder toBuilder() {
			LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder builder) {
			ofNullable(getOriginalPartyReference()).ifPresent(builder::setOriginalPartyReference);
			ofNullable(getAllocatedPartyReference()).ifPresent(builder::setAllocatedPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationPartiesModel _that = getType().cast(o);
		
			if (!Objects.equals(originalPartyReference, _that.getOriginalPartyReference())) return false;
			if (!Objects.equals(allocatedPartyReference, _that.getAllocatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originalPartyReference != null ? originalPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocatedPartyReference != null ? allocatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPartiesModel {" +
				"originalPartyReference=" + this.originalPartyReference + ", " +
				"allocatedPartyReference=" + this.allocatedPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationPartiesModel  ***********************/
	class LoanAllocationPartiesModelBuilderImpl implements LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder originalPartyReference;
		protected PartyReference.PartyReferenceBuilder allocatedPartyReference;
	
		public LoanAllocationPartiesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originalPartyReference")
		public PartyReference.PartyReferenceBuilder getOriginalPartyReference() {
			return originalPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOriginalPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (originalPartyReference!=null) {
				result = originalPartyReference;
			}
			else {
				result = originalPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocatedPartyReference")
		public PartyReference.PartyReferenceBuilder getAllocatedPartyReference() {
			return allocatedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAllocatedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (allocatedPartyReference!=null) {
				result = allocatedPartyReference;
			}
			else {
				result = allocatedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalPartyReference")
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder setOriginalPartyReference(PartyReference originalPartyReference) {
			this.originalPartyReference = originalPartyReference==null?null:originalPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocatedPartyReference")
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder setAllocatedPartyReference(PartyReference allocatedPartyReference) {
			this.allocatedPartyReference = allocatedPartyReference==null?null:allocatedPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationPartiesModel build() {
			return new LoanAllocationPartiesModel.LoanAllocationPartiesModelImpl(this);
		}
		
		@Override
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder prune() {
			if (originalPartyReference!=null && !originalPartyReference.prune().hasData()) originalPartyReference = null;
			if (allocatedPartyReference!=null && !allocatedPartyReference.prune().hasData()) allocatedPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginalPartyReference()!=null && getOriginalPartyReference().hasData()) return true;
			if (getAllocatedPartyReference()!=null && getAllocatedPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder o = (LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder) other;
			
			merger.mergeRosetta(getOriginalPartyReference(), o.getOriginalPartyReference(), this::setOriginalPartyReference);
			merger.mergeRosetta(getAllocatedPartyReference(), o.getAllocatedPartyReference(), this::setAllocatedPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationPartiesModel _that = getType().cast(o);
		
			if (!Objects.equals(originalPartyReference, _that.getOriginalPartyReference())) return false;
			if (!Objects.equals(allocatedPartyReference, _that.getAllocatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originalPartyReference != null ? originalPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocatedPartyReference != null ? allocatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPartiesModelBuilder {" +
				"originalPartyReference=" + this.originalPartyReference + ", " +
				"allocatedPartyReference=" + this.allocatedPartyReference +
			'}';
		}
	}
}
