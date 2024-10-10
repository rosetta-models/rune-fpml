package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxRangeAccrual;
import fpml.confirmation.FxRangeAccrual.FxRangeAccrualBuilder;
import fpml.confirmation.FxRangeAccrual.FxRangeAccrualBuilderImpl;
import fpml.confirmation.FxRangeAccrual.FxRangeAccrualImpl;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.FxRangeAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structured product which consists of a single cash payment or a strip of cash payments. At each settlement the settled amounts are a fraction of the notional amount for that settlement period calculated as the number of fixings which fall within accrual regions divided by the total number of fixings in the settlement period. An FX Range Accrual product. A strip of Digital Options product The product defines a list of fixing (or observation) dates. There are m total fixings. On the relevant Settlement Date, the Option Seller shall pay to the Option Buyer an amount, in the Settlement Currency, calculated according to the following formula: Accrual Currency and Notional Amount x (the total number of Accrual Days / Total Number of Calendar Days in the Accrual Period). Payout can be cash.
 * @version ${project.version}
 */
@RosettaDataType(value="FxRangeAccrual", builder=FxRangeAccrual.FxRangeAccrualBuilderImpl.class, version="${project.version}")
public interface FxRangeAccrual extends Product {

	FxRangeAccrualMeta metaData = new FxRangeAccrualMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * Describes accrual features within the product.
	 */
	FxAccrual getAccrual();
	FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel();
	FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel();
	/**
	 * Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 * Premium amount or premium installment amount for an option.
	 */
	List<? extends FxOptionPremium> getPremium();

	/*********************** Build Methods  ***********************/
	FxRangeAccrual build();
	
	FxRangeAccrual.FxRangeAccrualBuilder toBuilder();
	
	static FxRangeAccrual.FxRangeAccrualBuilder builder() {
		return new FxRangeAccrual.FxRangeAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRangeAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRangeAccrual> getType() {
		return FxRangeAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.class, getFxExpiryDateOrScheduleModel());
		processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.class, getFxSettlementDateOrScheduleModel());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRangeAccrualBuilder extends FxRangeAccrual, Product.ProductBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxAccrual.FxAccrualBuilder getOrCreateAccrual();
		FxAccrual.FxAccrualBuilder getAccrual();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index);
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		FxRangeAccrual.FxRangeAccrualBuilder setProductModel(ProductModel productModel);
		FxRangeAccrual.FxRangeAccrualBuilder setId(String id);
		FxRangeAccrual.FxRangeAccrualBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FxRangeAccrual.FxRangeAccrualBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxRangeAccrual.FxRangeAccrualBuilder setAccrual(FxAccrual accrual);
		FxRangeAccrual.FxRangeAccrualBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel);
		FxRangeAccrual.FxRangeAccrualBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier0);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier1, int _idx);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(List<? extends FxAccrualBarrier> barrier2);
		FxRangeAccrual.FxRangeAccrualBuilder setBarrier(List<? extends FxAccrualBarrier> barrier3);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium0);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium1, int _idx);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(List<? extends FxOptionPremium> premium2);
		FxRangeAccrual.FxRangeAccrualBuilder setPremium(List<? extends FxOptionPremium> premium3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder.class, getFxExpiryDateOrScheduleModel());
			processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder.class, getFxSettlementDateOrScheduleModel());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxRangeAccrual.FxRangeAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FxRangeAccrual  ***********************/
	class FxRangeAccrualImpl extends Product.ProductImpl implements FxRangeAccrual {
		private final PayerReceiverModel payerReceiverModel;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel;
		private final FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxRangeAccrualImpl(FxRangeAccrual.FxRangeAccrualBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.fxExpiryDateOrScheduleModel = ofNullable(builder.getFxExpiryDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.fxSettlementDateOrScheduleModel = ofNullable(builder.getFxSettlementDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium> getPremium() {
			return premium;
		}
		
		@Override
		public FxRangeAccrual build() {
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder toBuilder() {
			FxRangeAccrual.FxRangeAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRangeAccrual.FxRangeAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getFxExpiryDateOrScheduleModel()).ifPresent(builder::setFxExpiryDateOrScheduleModel);
			ofNullable(getFxSettlementDateOrScheduleModel()).ifPresent(builder::setFxSettlementDateOrScheduleModel);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRangeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRangeAccrual {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRangeAccrual  ***********************/
	class FxRangeAccrualBuilderImpl extends Product.ProductBuilderImpl  implements FxRangeAccrual.FxRangeAccrualBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder fxExpiryDateOrScheduleModel;
		protected FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder fxSettlementDateOrScheduleModel;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
	
		public FxRangeAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual.FxAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder getOrCreateAccrual() {
			FxAccrual.FxAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = FxAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel() {
			FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder result;
			if (fxExpiryDateOrScheduleModel!=null) {
				result = fxExpiryDateOrScheduleModel;
			}
			else {
				result = fxExpiryDateOrScheduleModel = FxExpiryDateOrScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel() {
			FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder result;
			if (fxSettlementDateOrScheduleModel!=null) {
				result = fxSettlementDateOrScheduleModel;
			}
			else {
				result = fxSettlementDateOrScheduleModel = FxSettlementDateOrScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		public FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxAccrualBarrier.FxAccrualBarrierBuilder result;
			return getIndex(barrier, _index, () -> {
						FxAccrualBarrier.FxAccrualBarrierBuilder newBarrier = FxAccrualBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium() {
			return premium;
		}
		
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			FxOptionPremium.FxOptionPremiumBuilder result;
			return getIndex(premium, _index, () -> {
						FxOptionPremium.FxOptionPremiumBuilder newPremium = FxOptionPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxRangeAccrual.FxRangeAccrualBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxRangeAccrual.FxRangeAccrualBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FxRangeAccrual.FxRangeAccrualBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxRangeAccrual.FxRangeAccrualBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrual")
		public FxRangeAccrual.FxRangeAccrualBuilder setAccrual(FxAccrual accrual) {
			this.accrual = accrual==null?null:accrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxRangeAccrual.FxRangeAccrualBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			this.fxExpiryDateOrScheduleModel = fxExpiryDateOrScheduleModel==null?null:fxExpiryDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxRangeAccrual.FxRangeAccrualBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			this.fxSettlementDateOrScheduleModel = fxSettlementDateOrScheduleModel==null?null:fxSettlementDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("barrier")
		public FxRangeAccrual.FxRangeAccrualBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null)  {
				this.barrier = new ArrayList<>();
			}
			else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("premium")
		public FxRangeAccrual.FxRangeAccrualBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxRangeAccrual build() {
			return new FxRangeAccrual.FxRangeAccrualImpl(this);
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (fxExpiryDateOrScheduleModel!=null && !fxExpiryDateOrScheduleModel.prune().hasData()) fxExpiryDateOrScheduleModel = null;
			if (fxSettlementDateOrScheduleModel!=null && !fxSettlementDateOrScheduleModel.prune().hasData()) fxSettlementDateOrScheduleModel = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getFxExpiryDateOrScheduleModel()!=null && getFxExpiryDateOrScheduleModel().hasData()) return true;
			if (getFxSettlementDateOrScheduleModel()!=null && getFxSettlementDateOrScheduleModel().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxRangeAccrual.FxRangeAccrualBuilder o = (FxRangeAccrual.FxRangeAccrualBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getFxExpiryDateOrScheduleModel(), o.getFxExpiryDateOrScheduleModel(), this::setFxExpiryDateOrScheduleModel);
			merger.mergeRosetta(getFxSettlementDateOrScheduleModel(), o.getFxSettlementDateOrScheduleModel(), this::setFxSettlementDateOrScheduleModel);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRangeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRangeAccrualBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}
