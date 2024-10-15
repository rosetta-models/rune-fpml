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
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder;
import fpml.confirmation.CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilderImpl;
import fpml.confirmation.CommodityFreightFlatRateModel.CommodityFreightFlatRateModelImpl;
import fpml.confirmation.FlatRateEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CommodityFreightFlatRateModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The Flat Rate, applicable to Wet Voyager Charter Freight Swaps.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFreightFlatRateModel", builder=CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilderImpl.class, version="${project.version}")
public interface CommodityFreightFlatRateModel extends RosettaModelObject {

	CommodityFreightFlatRateModelMeta metaData = new CommodityFreightFlatRateModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Whether the Flat Rate is the New Worldwide Tanker Nominal Freight Scale for the Freight Index Route taken at the Trade Date of the transaction or taken on each Pricing Date.
	 */
	FlatRateEnum getFlatRate();
	/**
	 * If flatRate is set to &quot;Fixed&quot;, the actual value of the Flat Rate.
	 */
	NonNegativeMoney getFlatRateAmount();

	/*********************** Build Methods  ***********************/
	CommodityFreightFlatRateModel build();
	
	CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder toBuilder();
	
	static CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder builder() {
		return new CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFreightFlatRateModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFreightFlatRateModel> getType() {
		return CommodityFreightFlatRateModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
		processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.class, getFlatRateAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFreightFlatRateModelBuilder extends CommodityFreightFlatRateModel, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateFlatRateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getFlatRateAmount();
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder setFlatRate(FlatRateEnum flatRate);
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder setFlatRateAmount(NonNegativeMoney flatRateAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
			processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getFlatRateAmount());
		}
		

		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFreightFlatRateModel  ***********************/
	class CommodityFreightFlatRateModelImpl implements CommodityFreightFlatRateModel {
		private final FlatRateEnum flatRate;
		private final NonNegativeMoney flatRateAmount;
		
		protected CommodityFreightFlatRateModelImpl(CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder builder) {
			this.flatRate = builder.getFlatRate();
			this.flatRateAmount = ofNullable(builder.getFlatRateAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("flatRate")
		public FlatRateEnum getFlatRate() {
			return flatRate;
		}
		
		@Override
		@RosettaAttribute("flatRateAmount")
		public NonNegativeMoney getFlatRateAmount() {
			return flatRateAmount;
		}
		
		@Override
		public CommodityFreightFlatRateModel build() {
			return this;
		}
		
		@Override
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder toBuilder() {
			CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder builder) {
			ofNullable(getFlatRate()).ifPresent(builder::setFlatRate);
			ofNullable(getFlatRateAmount()).ifPresent(builder::setFlatRateAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFreightFlatRateModel _that = getType().cast(o);
		
			if (!Objects.equals(flatRate, _that.getFlatRate())) return false;
			if (!Objects.equals(flatRateAmount, _that.getFlatRateAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (flatRate != null ? flatRate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (flatRateAmount != null ? flatRateAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFreightFlatRateModel {" +
				"flatRate=" + this.flatRate + ", " +
				"flatRateAmount=" + this.flatRateAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFreightFlatRateModel  ***********************/
	class CommodityFreightFlatRateModelBuilderImpl implements CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder {
	
		protected FlatRateEnum flatRate;
		protected NonNegativeMoney.NonNegativeMoneyBuilder flatRateAmount;
	
		public CommodityFreightFlatRateModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("flatRate")
		public FlatRateEnum getFlatRate() {
			return flatRate;
		}
		
		@Override
		@RosettaAttribute("flatRateAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getFlatRateAmount() {
			return flatRateAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateFlatRateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (flatRateAmount!=null) {
				result = flatRateAmount;
			}
			else {
				result = flatRateAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("flatRate")
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder setFlatRate(FlatRateEnum flatRate) {
			this.flatRate = flatRate==null?null:flatRate;
			return this;
		}
		@Override
		@RosettaAttribute("flatRateAmount")
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder setFlatRateAmount(NonNegativeMoney flatRateAmount) {
			this.flatRateAmount = flatRateAmount==null?null:flatRateAmount.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFreightFlatRateModel build() {
			return new CommodityFreightFlatRateModel.CommodityFreightFlatRateModelImpl(this);
		}
		
		@Override
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder prune() {
			if (flatRateAmount!=null && !flatRateAmount.prune().hasData()) flatRateAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFlatRate()!=null) return true;
			if (getFlatRateAmount()!=null && getFlatRateAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder o = (CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder) other;
			
			merger.mergeRosetta(getFlatRateAmount(), o.getFlatRateAmount(), this::setFlatRateAmount);
			
			merger.mergeBasic(getFlatRate(), o.getFlatRate(), this::setFlatRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFreightFlatRateModel _that = getType().cast(o);
		
			if (!Objects.equals(flatRate, _that.getFlatRate())) return false;
			if (!Objects.equals(flatRateAmount, _that.getFlatRateAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (flatRate != null ? flatRate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (flatRateAmount != null ? flatRateAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFreightFlatRateModelBuilder {" +
				"flatRate=" + this.flatRate + ", " +
				"flatRateAmount=" + this.flatRateAmount +
			'}';
		}
	}
}
