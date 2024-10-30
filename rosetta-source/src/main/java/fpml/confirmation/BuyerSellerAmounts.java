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
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.BuyerSellerAmounts.BuyerSellerAmountsBuilder;
import fpml.confirmation.BuyerSellerAmounts.BuyerSellerAmountsBuilderImpl;
import fpml.confirmation.BuyerSellerAmounts.BuyerSellerAmountsImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.BuyerSellerAmountsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the buyer and seller amounts of a payable.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BuyerSellerAmounts", builder=BuyerSellerAmounts.BuyerSellerAmountsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BuyerSellerAmounts extends RosettaModelObject {

	BuyerSellerAmountsMeta metaData = new BuyerSellerAmountsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The buyer&#39;s amount of a payable.
	 */
	NonNegativeMoney getBuyersAmount();
	/**
	 * The seller&#39;s amount of a payable.
	 */
	NonNegativeMoney getSellersAmount();

	/*********************** Build Methods  ***********************/
	BuyerSellerAmounts build();
	
	BuyerSellerAmounts.BuyerSellerAmountsBuilder toBuilder();
	
	static BuyerSellerAmounts.BuyerSellerAmountsBuilder builder() {
		return new BuyerSellerAmounts.BuyerSellerAmountsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BuyerSellerAmounts> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BuyerSellerAmounts> getType() {
		return BuyerSellerAmounts.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyersAmount"), processor, NonNegativeMoney.class, getBuyersAmount());
		processRosetta(path.newSubPath("sellersAmount"), processor, NonNegativeMoney.class, getSellersAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BuyerSellerAmountsBuilder extends BuyerSellerAmounts, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateBuyersAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getBuyersAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSellersAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getSellersAmount();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder setBuyersAmount(NonNegativeMoney buyersAmount);
		BuyerSellerAmounts.BuyerSellerAmountsBuilder setSellersAmount(NonNegativeMoney sellersAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyersAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getBuyersAmount());
			processRosetta(path.newSubPath("sellersAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getSellersAmount());
		}
		

		BuyerSellerAmounts.BuyerSellerAmountsBuilder prune();
	}

	/*********************** Immutable Implementation of BuyerSellerAmounts  ***********************/
	class BuyerSellerAmountsImpl implements BuyerSellerAmounts {
		private final NonNegativeMoney buyersAmount;
		private final NonNegativeMoney sellersAmount;
		
		protected BuyerSellerAmountsImpl(BuyerSellerAmounts.BuyerSellerAmountsBuilder builder) {
			this.buyersAmount = ofNullable(builder.getBuyersAmount()).map(f->f.build()).orElse(null);
			this.sellersAmount = ofNullable(builder.getSellersAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyersAmount")
		public NonNegativeMoney getBuyersAmount() {
			return buyersAmount;
		}
		
		@Override
		@RosettaAttribute("sellersAmount")
		public NonNegativeMoney getSellersAmount() {
			return sellersAmount;
		}
		
		@Override
		public BuyerSellerAmounts build() {
			return this;
		}
		
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder toBuilder() {
			BuyerSellerAmounts.BuyerSellerAmountsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BuyerSellerAmounts.BuyerSellerAmountsBuilder builder) {
			ofNullable(getBuyersAmount()).ifPresent(builder::setBuyersAmount);
			ofNullable(getSellersAmount()).ifPresent(builder::setSellersAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSellerAmounts _that = getType().cast(o);
		
			if (!Objects.equals(buyersAmount, _that.getBuyersAmount())) return false;
			if (!Objects.equals(sellersAmount, _that.getSellersAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyersAmount != null ? buyersAmount.hashCode() : 0);
			_result = 31 * _result + (sellersAmount != null ? sellersAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSellerAmounts {" +
				"buyersAmount=" + this.buyersAmount + ", " +
				"sellersAmount=" + this.sellersAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of BuyerSellerAmounts  ***********************/
	class BuyerSellerAmountsBuilderImpl implements BuyerSellerAmounts.BuyerSellerAmountsBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder buyersAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder sellersAmount;
	
		public BuyerSellerAmountsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyersAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getBuyersAmount() {
			return buyersAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateBuyersAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (buyersAmount!=null) {
				result = buyersAmount;
			}
			else {
				result = buyersAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellersAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getSellersAmount() {
			return sellersAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSellersAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (sellersAmount!=null) {
				result = sellersAmount;
			}
			else {
				result = sellersAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyersAmount")
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder setBuyersAmount(NonNegativeMoney buyersAmount) {
			this.buyersAmount = buyersAmount==null?null:buyersAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sellersAmount")
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder setSellersAmount(NonNegativeMoney sellersAmount) {
			this.sellersAmount = sellersAmount==null?null:sellersAmount.toBuilder();
			return this;
		}
		
		@Override
		public BuyerSellerAmounts build() {
			return new BuyerSellerAmounts.BuyerSellerAmountsImpl(this);
		}
		
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder prune() {
			if (buyersAmount!=null && !buyersAmount.prune().hasData()) buyersAmount = null;
			if (sellersAmount!=null && !sellersAmount.prune().hasData()) sellersAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyersAmount()!=null && getBuyersAmount().hasData()) return true;
			if (getSellersAmount()!=null && getSellersAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BuyerSellerAmounts.BuyerSellerAmountsBuilder o = (BuyerSellerAmounts.BuyerSellerAmountsBuilder) other;
			
			merger.mergeRosetta(getBuyersAmount(), o.getBuyersAmount(), this::setBuyersAmount);
			merger.mergeRosetta(getSellersAmount(), o.getSellersAmount(), this::setSellersAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSellerAmounts _that = getType().cast(o);
		
			if (!Objects.equals(buyersAmount, _that.getBuyersAmount())) return false;
			if (!Objects.equals(sellersAmount, _that.getSellersAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyersAmount != null ? buyersAmount.hashCode() : 0);
			_result = 31 * _result + (sellersAmount != null ? sellersAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSellerAmountsBuilder {" +
				"buyersAmount=" + this.buyersAmount + ", " +
				"sellersAmount=" + this.sellersAmount +
			'}';
		}
	}
}
