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
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.BasketReferenceInformation;
import fpml.confirmation.BasketReferenceInformation.BasketReferenceInformationBuilder;
import fpml.confirmation.BasketReferenceInformation.BasketReferenceInformationBuilderImpl;
import fpml.confirmation.BasketReferenceInformation.BasketReferenceInformationImpl;
import fpml.confirmation.BasketReferenceInformationSequence;
import fpml.confirmation.ReferencePool;
import fpml.confirmation.Tranche;
import fpml.confirmation.meta.BasketReferenceInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * CDS Basket Reference Information
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BasketReferenceInformation", builder=BasketReferenceInformation.BasketReferenceInformationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BasketReferenceInformation extends RosettaModelObject {

	BasketReferenceInformationMeta metaData = new BasketReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	BasketIdentifierModel getBasketIdentifierModel();
	/**
	 * This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket
	 */
	ReferencePool getReferencePool();
	BasketReferenceInformationSequence getBasketReferenceInformationSequence();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();

	/*********************** Build Methods  ***********************/
	BasketReferenceInformation build();
	
	BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder();
	
	static BasketReferenceInformation.BasketReferenceInformationBuilder builder() {
		return new BasketReferenceInformation.BasketReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketReferenceInformation> getType() {
		return BasketReferenceInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.class, getBasketIdentifierModel());
		processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.class, getReferencePool());
		processRosetta(path.newSubPath("basketReferenceInformationSequence"), processor, BasketReferenceInformationSequence.class, getBasketReferenceInformationSequence());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketReferenceInformationBuilder extends BasketReferenceInformation, RosettaModelObjectBuilder {
		BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel();
		BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel();
		ReferencePool.ReferencePoolBuilder getOrCreateReferencePool();
		ReferencePool.ReferencePoolBuilder getReferencePool();
		BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder getOrCreateBasketReferenceInformationSequence();
		BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder getBasketReferenceInformationSequence();
		Tranche.TrancheBuilder getOrCreateTranche();
		Tranche.TrancheBuilder getTranche();
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel);
		BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketReferenceInformationSequence(BasketReferenceInformationSequence basketReferenceInformationSequence);
		BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.BasketIdentifierModelBuilder.class, getBasketIdentifierModel());
			processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.ReferencePoolBuilder.class, getReferencePool());
			processRosetta(path.newSubPath("basketReferenceInformationSequence"), processor, BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder.class, getBasketReferenceInformationSequence());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
		}
		

		BasketReferenceInformation.BasketReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationImpl implements BasketReferenceInformation {
		private final BasketIdentifierModel basketIdentifierModel;
		private final ReferencePool referencePool;
		private final BasketReferenceInformationSequence basketReferenceInformationSequence;
		private final Tranche tranche;
		
		protected BasketReferenceInformationImpl(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			this.basketIdentifierModel = ofNullable(builder.getBasketIdentifierModel()).map(f->f.build()).orElse(null);
			this.referencePool = ofNullable(builder.getReferencePool()).map(f->f.build()).orElse(null);
			this.basketReferenceInformationSequence = ofNullable(builder.getBasketReferenceInformationSequence()).map(f->f.build()).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		@RosettaAttribute("referencePool")
		public ReferencePool getReferencePool() {
			return referencePool;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformationSequence")
		public BasketReferenceInformationSequence getBasketReferenceInformationSequence() {
			return basketReferenceInformationSequence;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			BasketReferenceInformation.BasketReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			ofNullable(getBasketIdentifierModel()).ifPresent(builder::setBasketIdentifierModel);
			ofNullable(getReferencePool()).ifPresent(builder::setReferencePool);
			ofNullable(getBasketReferenceInformationSequence()).ifPresent(builder::setBasketReferenceInformationSequence);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(basketReferenceInformationSequence, _that.getBasketReferenceInformationSequence())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformationSequence != null ? basketReferenceInformationSequence.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformation {" +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"referencePool=" + this.referencePool + ", " +
				"basketReferenceInformationSequence=" + this.basketReferenceInformationSequence + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationBuilderImpl implements BasketReferenceInformation.BasketReferenceInformationBuilder {
	
		protected BasketIdentifierModel.BasketIdentifierModelBuilder basketIdentifierModel;
		protected ReferencePool.ReferencePoolBuilder referencePool;
		protected BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder basketReferenceInformationSequence;
		protected Tranche.TrancheBuilder tranche;
	
		public BasketReferenceInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel() {
			BasketIdentifierModel.BasketIdentifierModelBuilder result;
			if (basketIdentifierModel!=null) {
				result = basketIdentifierModel;
			}
			else {
				result = basketIdentifierModel = BasketIdentifierModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referencePool")
		public ReferencePool.ReferencePoolBuilder getReferencePool() {
			return referencePool;
		}
		
		@Override
		public ReferencePool.ReferencePoolBuilder getOrCreateReferencePool() {
			ReferencePool.ReferencePoolBuilder result;
			if (referencePool!=null) {
				result = referencePool;
			}
			else {
				result = referencePool = ReferencePool.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformationSequence")
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder getBasketReferenceInformationSequence() {
			return basketReferenceInformationSequence;
		}
		
		@Override
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder getOrCreateBasketReferenceInformationSequence() {
			BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder result;
			if (basketReferenceInformationSequence!=null) {
				result = basketReferenceInformationSequence;
			}
			else {
				result = basketReferenceInformationSequence = BasketReferenceInformationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel) {
			this.basketIdentifierModel = basketIdentifierModel==null?null:basketIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referencePool")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool) {
			this.referencePool = referencePool==null?null:referencePool.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("basketReferenceInformationSequence")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketReferenceInformationSequence(BasketReferenceInformationSequence basketReferenceInformationSequence) {
			this.basketReferenceInformationSequence = basketReferenceInformationSequence==null?null:basketReferenceInformationSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tranche")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return new BasketReferenceInformation.BasketReferenceInformationImpl(this);
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder prune() {
			if (basketIdentifierModel!=null && !basketIdentifierModel.prune().hasData()) basketIdentifierModel = null;
			if (referencePool!=null && !referencePool.prune().hasData()) referencePool = null;
			if (basketReferenceInformationSequence!=null && !basketReferenceInformationSequence.prune().hasData()) basketReferenceInformationSequence = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketIdentifierModel()!=null && getBasketIdentifierModel().hasData()) return true;
			if (getReferencePool()!=null && getReferencePool().hasData()) return true;
			if (getBasketReferenceInformationSequence()!=null && getBasketReferenceInformationSequence().hasData()) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketReferenceInformation.BasketReferenceInformationBuilder o = (BasketReferenceInformation.BasketReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getBasketIdentifierModel(), o.getBasketIdentifierModel(), this::setBasketIdentifierModel);
			merger.mergeRosetta(getReferencePool(), o.getReferencePool(), this::setReferencePool);
			merger.mergeRosetta(getBasketReferenceInformationSequence(), o.getBasketReferenceInformationSequence(), this::setBasketReferenceInformationSequence);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(basketReferenceInformationSequence, _that.getBasketReferenceInformationSequence())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformationSequence != null ? basketReferenceInformationSequence.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationBuilder {" +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"referencePool=" + this.referencePool + ", " +
				"basketReferenceInformationSequence=" + this.basketReferenceInformationSequence + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
}
