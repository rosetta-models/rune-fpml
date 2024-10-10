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
import fpml.confirmation.BondReference;
import fpml.confirmation.SwapAdditionalTerms;
import fpml.confirmation.SwapAdditionalTerms.SwapAdditionalTermsBuilder;
import fpml.confirmation.SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl;
import fpml.confirmation.SwapAdditionalTerms.SwapAdditionalTermsImpl;
import fpml.confirmation.meta.SwapAdditionalTermsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Additional terms to a swap contract.
 * @version ${project.version}
 */
@RosettaDataType(value="SwapAdditionalTerms", builder=SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl.class, version="${project.version}")
public interface SwapAdditionalTerms extends RosettaModelObject {

	SwapAdditionalTermsMeta metaData = new SwapAdditionalTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a bond underlyer to represent an asset swap or Condition Precedent Bond.
	 */
	BondReference getBondReference();

	/*********************** Build Methods  ***********************/
	SwapAdditionalTerms build();
	
	SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder();
	
	static SwapAdditionalTerms.SwapAdditionalTermsBuilder builder() {
		return new SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwapAdditionalTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SwapAdditionalTerms> getType() {
		return SwapAdditionalTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bondReference"), processor, BondReference.class, getBondReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwapAdditionalTermsBuilder extends SwapAdditionalTerms, RosettaModelObjectBuilder {
		BondReference.BondReferenceBuilder getOrCreateBondReference();
		BondReference.BondReferenceBuilder getBondReference();
		SwapAdditionalTerms.SwapAdditionalTermsBuilder setBondReference(BondReference bondReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bondReference"), processor, BondReference.BondReferenceBuilder.class, getBondReference());
		}
		

		SwapAdditionalTerms.SwapAdditionalTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SwapAdditionalTerms  ***********************/
	class SwapAdditionalTermsImpl implements SwapAdditionalTerms {
		private final BondReference bondReference;
		
		protected SwapAdditionalTermsImpl(SwapAdditionalTerms.SwapAdditionalTermsBuilder builder) {
			this.bondReference = ofNullable(builder.getBondReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bondReference")
		public BondReference getBondReference() {
			return bondReference;
		}
		
		@Override
		public SwapAdditionalTerms build() {
			return this;
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder() {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwapAdditionalTerms.SwapAdditionalTermsBuilder builder) {
			ofNullable(getBondReference()).ifPresent(builder::setBondReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapAdditionalTerms {" +
				"bondReference=" + this.bondReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SwapAdditionalTerms  ***********************/
	class SwapAdditionalTermsBuilderImpl implements SwapAdditionalTerms.SwapAdditionalTermsBuilder {
	
		protected BondReference.BondReferenceBuilder bondReference;
	
		public SwapAdditionalTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bondReference")
		public BondReference.BondReferenceBuilder getBondReference() {
			return bondReference;
		}
		
		@Override
		public BondReference.BondReferenceBuilder getOrCreateBondReference() {
			BondReference.BondReferenceBuilder result;
			if (bondReference!=null) {
				result = bondReference;
			}
			else {
				result = bondReference = BondReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondReference")
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder setBondReference(BondReference bondReference) {
			this.bondReference = bondReference==null?null:bondReference.toBuilder();
			return this;
		}
		
		@Override
		public SwapAdditionalTerms build() {
			return new SwapAdditionalTerms.SwapAdditionalTermsImpl(this);
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder prune() {
			if (bondReference!=null && !bondReference.prune().hasData()) bondReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondReference()!=null && getBondReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder o = (SwapAdditionalTerms.SwapAdditionalTermsBuilder) other;
			
			merger.mergeRosetta(getBondReference(), o.getBondReference(), this::setBondReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapAdditionalTermsBuilder {" +
				"bondReference=" + this.bondReference +
			'}';
		}
	}
}
