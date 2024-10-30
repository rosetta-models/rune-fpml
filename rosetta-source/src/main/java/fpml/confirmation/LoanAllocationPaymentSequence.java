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
import fpml.confirmation.LoanAllocationPaymentSequence;
import fpml.confirmation.LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder;
import fpml.confirmation.LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilderImpl;
import fpml.confirmation.LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceImpl;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.meta.LoanAllocationPaymentSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanAllocationPaymentSequence", builder=LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanAllocationPaymentSequence extends RosettaModelObject {

	LoanAllocationPaymentSequenceMeta metaData = new LoanAllocationPaymentSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the loan trade allocation.
	 */
	LoanAllocationReference getAllocationReference();

	/*********************** Build Methods  ***********************/
	LoanAllocationPaymentSequence build();
	
	LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder toBuilder();
	
	static LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder builder() {
		return new LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationPaymentSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationPaymentSequence> getType() {
		return LoanAllocationPaymentSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationPaymentSequenceBuilder extends LoanAllocationPaymentSequence, RosettaModelObjectBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference();
		LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference();
		LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder setAllocationReference(LoanAllocationReference allocationReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
		}
		

		LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationPaymentSequence  ***********************/
	class LoanAllocationPaymentSequenceImpl implements LoanAllocationPaymentSequence {
		private final LoanAllocationReference allocationReference;
		
		protected LoanAllocationPaymentSequenceImpl(LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder builder) {
			this.allocationReference = ofNullable(builder.getAllocationReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationPaymentSequence build() {
			return this;
		}
		
		@Override
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder toBuilder() {
			LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder builder) {
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPaymentSequence {" +
				"allocationReference=" + this.allocationReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationPaymentSequence  ***********************/
	class LoanAllocationPaymentSequenceBuilderImpl implements LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder {
	
		protected LoanAllocationReference.LoanAllocationReferenceBuilder allocationReference;
	
		public LoanAllocationPaymentSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference() {
			LoanAllocationReference.LoanAllocationReferenceBuilder result;
			if (allocationReference!=null) {
				result = allocationReference;
			}
			else {
				result = allocationReference = LoanAllocationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder setAllocationReference(LoanAllocationReference allocationReference) {
			this.allocationReference = allocationReference==null?null:allocationReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationPaymentSequence build() {
			return new LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceImpl(this);
		}
		
		@Override
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder prune() {
			if (allocationReference!=null && !allocationReference.prune().hasData()) allocationReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationReference()!=null && getAllocationReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder o = (LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::setAllocationReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPaymentSequenceBuilder {" +
				"allocationReference=" + this.allocationReference +
			'}';
		}
	}
}
