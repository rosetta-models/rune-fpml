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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.ReturnSwapBase;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilder;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilderImpl;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseImpl;
import fpml.confirmation.meta.ReturnSwapBaseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing the components that are common for return type swaps, including short and long form return swaps representations.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapBase", builder=ReturnSwapBase.ReturnSwapBaseBuilderImpl.class, version="${project.version}")
public interface ReturnSwapBase extends Product {

	ReturnSwapBaseMeta metaData = new ReturnSwapBaseMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	List<? extends DirectionalLeg> getReturnSwapLeg();
	/**
	 * This is used to document a Fully Funded Return Swap.
	 */
	PrincipalExchangeFeatures getPrincipalExchangeFeatures();
	/**
	 * Specifies additional payment(s) between the principal parties to the trade.
	 */
	List<? extends ReturnSwapAdditionalPayment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	ReturnSwapBase build();
	
	ReturnSwapBase.ReturnSwapBaseBuilder toBuilder();
	
	static ReturnSwapBase.ReturnSwapBaseBuilder builder() {
		return new ReturnSwapBase.ReturnSwapBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapBase> getType() {
		return ReturnSwapBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.class, getReturnSwapLeg());
		processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.class, getPrincipalExchangeFeatures());
		processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapBaseBuilder extends ReturnSwapBase, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		DirectionalLeg.DirectionalLegBuilder getOrCreateReturnSwapLeg(int _index);
		List<? extends DirectionalLeg.DirectionalLegBuilder> getReturnSwapLeg();
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getOrCreatePrincipalExchangeFeatures();
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getPrincipalExchangeFeatures();
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> getAdditionalPayment();
		ReturnSwapBase.ReturnSwapBaseBuilder setProductModel(ProductModel productModel);
		ReturnSwapBase.ReturnSwapBaseBuilder setId(String id);
		ReturnSwapBase.ReturnSwapBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg0);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg1, int _idx);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg2);
		ReturnSwapBase.ReturnSwapBaseBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg3);
		ReturnSwapBase.ReturnSwapBaseBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment0);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment1, int _idx);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment2);
		ReturnSwapBase.ReturnSwapBaseBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.DirectionalLegBuilder.class, getReturnSwapLeg());
			processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder.class, getPrincipalExchangeFeatures());
			processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder.class, getAdditionalPayment());
		}
		

		ReturnSwapBase.ReturnSwapBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapBase  ***********************/
	class ReturnSwapBaseImpl extends Product.ProductImpl implements ReturnSwapBase {
		private final BuyerSellerModel buyerSellerModel;
		private final List<? extends DirectionalLeg> returnSwapLeg;
		private final PrincipalExchangeFeatures principalExchangeFeatures;
		private final List<? extends ReturnSwapAdditionalPayment> additionalPayment;
		
		protected ReturnSwapBaseImpl(ReturnSwapBase.ReturnSwapBaseBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.returnSwapLeg = ofNullable(builder.getReturnSwapLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.principalExchangeFeatures = ofNullable(builder.getPrincipalExchangeFeatures()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("returnSwapLeg")
		public List<? extends DirectionalLeg> getReturnSwapLeg() {
			return returnSwapLeg;
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		public PrincipalExchangeFeatures getPrincipalExchangeFeatures() {
			return principalExchangeFeatures;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends ReturnSwapAdditionalPayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public ReturnSwapBase build() {
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder toBuilder() {
			ReturnSwapBase.ReturnSwapBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapBase.ReturnSwapBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getReturnSwapLeg()).ifPresent(builder::setReturnSwapLeg);
			ofNullable(getPrincipalExchangeFeatures()).ifPresent(builder::setPrincipalExchangeFeatures);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(returnSwapLeg, _that.getReturnSwapLeg())) return false;
			if (!Objects.equals(principalExchangeFeatures, _that.getPrincipalExchangeFeatures())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (returnSwapLeg != null ? returnSwapLeg.hashCode() : 0);
			_result = 31 * _result + (principalExchangeFeatures != null ? principalExchangeFeatures.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBase {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"returnSwapLeg=" + this.returnSwapLeg + ", " +
				"principalExchangeFeatures=" + this.principalExchangeFeatures + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapBase  ***********************/
	class ReturnSwapBaseBuilderImpl extends Product.ProductBuilderImpl  implements ReturnSwapBase.ReturnSwapBaseBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected List<DirectionalLeg.DirectionalLegBuilder> returnSwapLeg = new ArrayList<>();
		protected PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder principalExchangeFeatures;
		protected List<ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> additionalPayment = new ArrayList<>();
	
		public ReturnSwapBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("returnSwapLeg")
		public List<? extends DirectionalLeg.DirectionalLegBuilder> getReturnSwapLeg() {
			return returnSwapLeg;
		}
		
		@Override
		public DirectionalLeg.DirectionalLegBuilder getOrCreateReturnSwapLeg(int _index) {
		
			if (returnSwapLeg==null) {
				this.returnSwapLeg = new ArrayList<>();
			}
			DirectionalLeg.DirectionalLegBuilder result;
			return getIndex(returnSwapLeg, _index, () -> {
						DirectionalLeg.DirectionalLegBuilder newReturnSwapLeg = DirectionalLeg.builder();
						return newReturnSwapLeg;
					});
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getPrincipalExchangeFeatures() {
			return principalExchangeFeatures;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getOrCreatePrincipalExchangeFeatures() {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder result;
			if (principalExchangeFeatures!=null) {
				result = principalExchangeFeatures;
			}
			else {
				result = principalExchangeFeatures = PrincipalExchangeFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder newAdditionalPayment = ReturnSwapAdditionalPayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public ReturnSwapBase.ReturnSwapBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReturnSwapBase.ReturnSwapBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public ReturnSwapBase.ReturnSwapBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("returnSwapLeg")
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg) {
			if (returnSwapLeg!=null) this.returnSwapLeg.add(returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int _idx) {
			getIndex(this.returnSwapLeg, _idx, () -> returnSwapLeg.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs != null) {
				for (DirectionalLeg toAdd : returnSwapLegs) {
					this.returnSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReturnSwapBase.ReturnSwapBaseBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs == null)  {
				this.returnSwapLeg = new ArrayList<>();
			}
			else {
				this.returnSwapLeg = returnSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		public ReturnSwapBase.ReturnSwapBaseBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures) {
			this.principalExchangeFeatures = principalExchangeFeatures==null?null:principalExchangeFeatures.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ReturnSwapAdditionalPayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReturnSwapBase.ReturnSwapBaseBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ReturnSwapBase build() {
			return new ReturnSwapBase.ReturnSwapBaseImpl(this);
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			returnSwapLeg = returnSwapLeg.stream().filter(b->b!=null).<DirectionalLeg.DirectionalLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (principalExchangeFeatures!=null && !principalExchangeFeatures.prune().hasData()) principalExchangeFeatures = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getReturnSwapLeg()!=null && getReturnSwapLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrincipalExchangeFeatures()!=null && getPrincipalExchangeFeatures().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapBase.ReturnSwapBaseBuilder o = (ReturnSwapBase.ReturnSwapBaseBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getReturnSwapLeg(), o.getReturnSwapLeg(), this::getOrCreateReturnSwapLeg);
			merger.mergeRosetta(getPrincipalExchangeFeatures(), o.getPrincipalExchangeFeatures(), this::setPrincipalExchangeFeatures);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(returnSwapLeg, _that.getReturnSwapLeg())) return false;
			if (!Objects.equals(principalExchangeFeatures, _that.getPrincipalExchangeFeatures())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (returnSwapLeg != null ? returnSwapLeg.hashCode() : 0);
			_result = 31 * _result + (principalExchangeFeatures != null ? principalExchangeFeatures.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBaseBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"returnSwapLeg=" + this.returnSwapLeg + ", " +
				"principalExchangeFeatures=" + this.principalExchangeFeatures + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
