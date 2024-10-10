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
import fpml.confirmation.AssetReference;
import fpml.confirmation.BondCollateralModel;
import fpml.confirmation.CollateralValuation;
import fpml.confirmation.CollateralValuation.CollateralValuationBuilder;
import fpml.confirmation.CollateralValuation.CollateralValuationBuilderImpl;
import fpml.confirmation.CollateralValuation.CollateralValuationImpl;
import fpml.confirmation.UnitContractModel;
import fpml.confirmation.meta.CollateralValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This type is used in Repo trades, to specify the valuation of a specific piece of collateral in the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralValuation", builder=CollateralValuation.CollateralValuationBuilderImpl.class, version="${project.version}")
public interface CollateralValuation extends RosettaModelObject {

	CollateralValuationMeta metaData = new CollateralValuationMeta();

	/*********************** Getter Methods  ***********************/
	BondCollateralModel getBondCollateralModel();
	UnitContractModel getUnitContractModel();
	/**
	 * A reference to explicitly identify which asset is being valued.
	 */
	AssetReference getAssetReference();

	/*********************** Build Methods  ***********************/
	CollateralValuation build();
	
	CollateralValuation.CollateralValuationBuilder toBuilder();
	
	static CollateralValuation.CollateralValuationBuilder builder() {
		return new CollateralValuation.CollateralValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralValuation> getType() {
		return CollateralValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bondCollateralModel"), processor, BondCollateralModel.class, getBondCollateralModel());
		processRosetta(path.newSubPath("unitContractModel"), processor, UnitContractModel.class, getUnitContractModel());
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValuationBuilder extends CollateralValuation, RosettaModelObjectBuilder {
		BondCollateralModel.BondCollateralModelBuilder getOrCreateBondCollateralModel();
		BondCollateralModel.BondCollateralModelBuilder getBondCollateralModel();
		UnitContractModel.UnitContractModelBuilder getOrCreateUnitContractModel();
		UnitContractModel.UnitContractModelBuilder getUnitContractModel();
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		AssetReference.AssetReferenceBuilder getAssetReference();
		CollateralValuation.CollateralValuationBuilder setBondCollateralModel(BondCollateralModel bondCollateralModel);
		CollateralValuation.CollateralValuationBuilder setUnitContractModel(UnitContractModel unitContractModel);
		CollateralValuation.CollateralValuationBuilder setAssetReference(AssetReference assetReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bondCollateralModel"), processor, BondCollateralModel.BondCollateralModelBuilder.class, getBondCollateralModel());
			processRosetta(path.newSubPath("unitContractModel"), processor, UnitContractModel.UnitContractModelBuilder.class, getUnitContractModel());
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
		}
		

		CollateralValuation.CollateralValuationBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValuation  ***********************/
	class CollateralValuationImpl implements CollateralValuation {
		private final BondCollateralModel bondCollateralModel;
		private final UnitContractModel unitContractModel;
		private final AssetReference assetReference;
		
		protected CollateralValuationImpl(CollateralValuation.CollateralValuationBuilder builder) {
			this.bondCollateralModel = ofNullable(builder.getBondCollateralModel()).map(f->f.build()).orElse(null);
			this.unitContractModel = ofNullable(builder.getUnitContractModel()).map(f->f.build()).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bondCollateralModel")
		public BondCollateralModel getBondCollateralModel() {
			return bondCollateralModel;
		}
		
		@Override
		@RosettaAttribute("unitContractModel")
		public UnitContractModel getUnitContractModel() {
			return unitContractModel;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		public CollateralValuation build() {
			return this;
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder toBuilder() {
			CollateralValuation.CollateralValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuation.CollateralValuationBuilder builder) {
			ofNullable(getBondCollateralModel()).ifPresent(builder::setBondCollateralModel);
			ofNullable(getUnitContractModel()).ifPresent(builder::setUnitContractModel);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(bondCollateralModel, _that.getBondCollateralModel())) return false;
			if (!Objects.equals(unitContractModel, _that.getUnitContractModel())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondCollateralModel != null ? bondCollateralModel.hashCode() : 0);
			_result = 31 * _result + (unitContractModel != null ? unitContractModel.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuation {" +
				"bondCollateralModel=" + this.bondCollateralModel + ", " +
				"unitContractModel=" + this.unitContractModel + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValuation  ***********************/
	class CollateralValuationBuilderImpl implements CollateralValuation.CollateralValuationBuilder {
	
		protected BondCollateralModel.BondCollateralModelBuilder bondCollateralModel;
		protected UnitContractModel.UnitContractModelBuilder unitContractModel;
		protected AssetReference.AssetReferenceBuilder assetReference;
	
		public CollateralValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bondCollateralModel")
		public BondCollateralModel.BondCollateralModelBuilder getBondCollateralModel() {
			return bondCollateralModel;
		}
		
		@Override
		public BondCollateralModel.BondCollateralModelBuilder getOrCreateBondCollateralModel() {
			BondCollateralModel.BondCollateralModelBuilder result;
			if (bondCollateralModel!=null) {
				result = bondCollateralModel;
			}
			else {
				result = bondCollateralModel = BondCollateralModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unitContractModel")
		public UnitContractModel.UnitContractModelBuilder getUnitContractModel() {
			return unitContractModel;
		}
		
		@Override
		public UnitContractModel.UnitContractModelBuilder getOrCreateUnitContractModel() {
			UnitContractModel.UnitContractModelBuilder result;
			if (unitContractModel!=null) {
				result = unitContractModel;
			}
			else {
				result = unitContractModel = UnitContractModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondCollateralModel")
		public CollateralValuation.CollateralValuationBuilder setBondCollateralModel(BondCollateralModel bondCollateralModel) {
			this.bondCollateralModel = bondCollateralModel==null?null:bondCollateralModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unitContractModel")
		public CollateralValuation.CollateralValuationBuilder setUnitContractModel(UnitContractModel unitContractModel) {
			this.unitContractModel = unitContractModel==null?null:unitContractModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetReference")
		public CollateralValuation.CollateralValuationBuilder setAssetReference(AssetReference assetReference) {
			this.assetReference = assetReference==null?null:assetReference.toBuilder();
			return this;
		}
		
		@Override
		public CollateralValuation build() {
			return new CollateralValuation.CollateralValuationImpl(this);
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuation.CollateralValuationBuilder prune() {
			if (bondCollateralModel!=null && !bondCollateralModel.prune().hasData()) bondCollateralModel = null;
			if (unitContractModel!=null && !unitContractModel.prune().hasData()) unitContractModel = null;
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondCollateralModel()!=null && getBondCollateralModel().hasData()) return true;
			if (getUnitContractModel()!=null && getUnitContractModel().hasData()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuation.CollateralValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuation.CollateralValuationBuilder o = (CollateralValuation.CollateralValuationBuilder) other;
			
			merger.mergeRosetta(getBondCollateralModel(), o.getBondCollateralModel(), this::setBondCollateralModel);
			merger.mergeRosetta(getUnitContractModel(), o.getUnitContractModel(), this::setUnitContractModel);
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(bondCollateralModel, _that.getBondCollateralModel())) return false;
			if (!Objects.equals(unitContractModel, _that.getUnitContractModel())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondCollateralModel != null ? bondCollateralModel.hashCode() : 0);
			_result = 31 * _result + (unitContractModel != null ? unitContractModel.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationBuilder {" +
				"bondCollateralModel=" + this.bondCollateralModel + ", " +
				"unitContractModel=" + this.unitContractModel + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}
}
