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
import fpml.confirmation.BondCollateralModel;
import fpml.confirmation.BondCollateralModel.BondCollateralModelBuilder;
import fpml.confirmation.BondCollateralModel.BondCollateralModelBuilderImpl;
import fpml.confirmation.BondCollateralModel.BondCollateralModelImpl;
import fpml.confirmation.BondPriceAndYieldModel;
import fpml.confirmation.Money;
import fpml.confirmation.meta.BondCollateralModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group which has Collateral elements.
 * @version ${project.version}
 */
@RosettaDataType(value="BondCollateralModel", builder=BondCollateralModel.BondCollateralModelBuilderImpl.class, version="${project.version}")
public interface BondCollateralModel extends RosettaModelObject {

	BondCollateralModelMeta metaData = new BondCollateralModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Total nominal amount of the given bonds used as collateral.
	 */
	Money getNominalAmount();
	BondPriceAndYieldModel getBondPriceAndYieldModel();
	/**
	 * Accruals expressed as amount.
	 */
	Money getAccrualsAmount();

	/*********************** Build Methods  ***********************/
	BondCollateralModel build();
	
	BondCollateralModel.BondCollateralModelBuilder toBuilder();
	
	static BondCollateralModel.BondCollateralModelBuilder builder() {
		return new BondCollateralModel.BondCollateralModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondCollateralModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondCollateralModel> getType() {
		return BondCollateralModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nominalAmount"), processor, Money.class, getNominalAmount());
		processRosetta(path.newSubPath("bondPriceAndYieldModel"), processor, BondPriceAndYieldModel.class, getBondPriceAndYieldModel());
		processRosetta(path.newSubPath("accrualsAmount"), processor, Money.class, getAccrualsAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondCollateralModelBuilder extends BondCollateralModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateNominalAmount();
		Money.MoneyBuilder getNominalAmount();
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getOrCreateBondPriceAndYieldModel();
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getBondPriceAndYieldModel();
		Money.MoneyBuilder getOrCreateAccrualsAmount();
		Money.MoneyBuilder getAccrualsAmount();
		BondCollateralModel.BondCollateralModelBuilder setNominalAmount(Money nominalAmount);
		BondCollateralModel.BondCollateralModelBuilder setBondPriceAndYieldModel(BondPriceAndYieldModel bondPriceAndYieldModel);
		BondCollateralModel.BondCollateralModelBuilder setAccrualsAmount(Money accrualsAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nominalAmount"), processor, Money.MoneyBuilder.class, getNominalAmount());
			processRosetta(path.newSubPath("bondPriceAndYieldModel"), processor, BondPriceAndYieldModel.BondPriceAndYieldModelBuilder.class, getBondPriceAndYieldModel());
			processRosetta(path.newSubPath("accrualsAmount"), processor, Money.MoneyBuilder.class, getAccrualsAmount());
		}
		

		BondCollateralModel.BondCollateralModelBuilder prune();
	}

	/*********************** Immutable Implementation of BondCollateralModel  ***********************/
	class BondCollateralModelImpl implements BondCollateralModel {
		private final Money nominalAmount;
		private final BondPriceAndYieldModel bondPriceAndYieldModel;
		private final Money accrualsAmount;
		
		protected BondCollateralModelImpl(BondCollateralModel.BondCollateralModelBuilder builder) {
			this.nominalAmount = ofNullable(builder.getNominalAmount()).map(f->f.build()).orElse(null);
			this.bondPriceAndYieldModel = ofNullable(builder.getBondPriceAndYieldModel()).map(f->f.build()).orElse(null);
			this.accrualsAmount = ofNullable(builder.getAccrualsAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nominalAmount")
		public Money getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		@RosettaAttribute("bondPriceAndYieldModel")
		public BondPriceAndYieldModel getBondPriceAndYieldModel() {
			return bondPriceAndYieldModel;
		}
		
		@Override
		@RosettaAttribute("accrualsAmount")
		public Money getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		public BondCollateralModel build() {
			return this;
		}
		
		@Override
		public BondCollateralModel.BondCollateralModelBuilder toBuilder() {
			BondCollateralModel.BondCollateralModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondCollateralModel.BondCollateralModelBuilder builder) {
			ofNullable(getNominalAmount()).ifPresent(builder::setNominalAmount);
			ofNullable(getBondPriceAndYieldModel()).ifPresent(builder::setBondPriceAndYieldModel);
			ofNullable(getAccrualsAmount()).ifPresent(builder::setAccrualsAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondCollateralModel _that = getType().cast(o);
		
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(bondPriceAndYieldModel, _that.getBondPriceAndYieldModel())) return false;
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (bondPriceAndYieldModel != null ? bondPriceAndYieldModel.hashCode() : 0);
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondCollateralModel {" +
				"nominalAmount=" + this.nominalAmount + ", " +
				"bondPriceAndYieldModel=" + this.bondPriceAndYieldModel + ", " +
				"accrualsAmount=" + this.accrualsAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of BondCollateralModel  ***********************/
	class BondCollateralModelBuilderImpl implements BondCollateralModel.BondCollateralModelBuilder {
	
		protected Money.MoneyBuilder nominalAmount;
		protected BondPriceAndYieldModel.BondPriceAndYieldModelBuilder bondPriceAndYieldModel;
		protected Money.MoneyBuilder accrualsAmount;
	
		public BondCollateralModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("nominalAmount")
		public Money.MoneyBuilder getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNominalAmount() {
			Money.MoneyBuilder result;
			if (nominalAmount!=null) {
				result = nominalAmount;
			}
			else {
				result = nominalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondPriceAndYieldModel")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getBondPriceAndYieldModel() {
			return bondPriceAndYieldModel;
		}
		
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder getOrCreateBondPriceAndYieldModel() {
			BondPriceAndYieldModel.BondPriceAndYieldModelBuilder result;
			if (bondPriceAndYieldModel!=null) {
				result = bondPriceAndYieldModel;
			}
			else {
				result = bondPriceAndYieldModel = BondPriceAndYieldModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualsAmount")
		public Money.MoneyBuilder getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAccrualsAmount() {
			Money.MoneyBuilder result;
			if (accrualsAmount!=null) {
				result = accrualsAmount;
			}
			else {
				result = accrualsAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nominalAmount")
		public BondCollateralModel.BondCollateralModelBuilder setNominalAmount(Money nominalAmount) {
			this.nominalAmount = nominalAmount==null?null:nominalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bondPriceAndYieldModel")
		public BondCollateralModel.BondCollateralModelBuilder setBondPriceAndYieldModel(BondPriceAndYieldModel bondPriceAndYieldModel) {
			this.bondPriceAndYieldModel = bondPriceAndYieldModel==null?null:bondPriceAndYieldModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrualsAmount")
		public BondCollateralModel.BondCollateralModelBuilder setAccrualsAmount(Money accrualsAmount) {
			this.accrualsAmount = accrualsAmount==null?null:accrualsAmount.toBuilder();
			return this;
		}
		
		@Override
		public BondCollateralModel build() {
			return new BondCollateralModel.BondCollateralModelImpl(this);
		}
		
		@Override
		public BondCollateralModel.BondCollateralModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondCollateralModel.BondCollateralModelBuilder prune() {
			if (nominalAmount!=null && !nominalAmount.prune().hasData()) nominalAmount = null;
			if (bondPriceAndYieldModel!=null && !bondPriceAndYieldModel.prune().hasData()) bondPriceAndYieldModel = null;
			if (accrualsAmount!=null && !accrualsAmount.prune().hasData()) accrualsAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNominalAmount()!=null && getNominalAmount().hasData()) return true;
			if (getBondPriceAndYieldModel()!=null && getBondPriceAndYieldModel().hasData()) return true;
			if (getAccrualsAmount()!=null && getAccrualsAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondCollateralModel.BondCollateralModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondCollateralModel.BondCollateralModelBuilder o = (BondCollateralModel.BondCollateralModelBuilder) other;
			
			merger.mergeRosetta(getNominalAmount(), o.getNominalAmount(), this::setNominalAmount);
			merger.mergeRosetta(getBondPriceAndYieldModel(), o.getBondPriceAndYieldModel(), this::setBondPriceAndYieldModel);
			merger.mergeRosetta(getAccrualsAmount(), o.getAccrualsAmount(), this::setAccrualsAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondCollateralModel _that = getType().cast(o);
		
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(bondPriceAndYieldModel, _that.getBondPriceAndYieldModel())) return false;
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (bondPriceAndYieldModel != null ? bondPriceAndYieldModel.hashCode() : 0);
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondCollateralModelBuilder {" +
				"nominalAmount=" + this.nominalAmount + ", " +
				"bondPriceAndYieldModel=" + this.bondPriceAndYieldModel + ", " +
				"accrualsAmount=" + this.accrualsAmount +
			'}';
		}
	}
}
