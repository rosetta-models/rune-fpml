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
import fpml.confirmation.Asset;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.InstrumentTradeDetails;
import fpml.confirmation.InstrumentTradeDetails.InstrumentTradeDetailsBuilder;
import fpml.confirmation.InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl;
import fpml.confirmation.InstrumentTradeDetails.InstrumentTradeDetailsImpl;
import fpml.confirmation.InstrumentTradePricing;
import fpml.confirmation.InstrumentTradePrincipal;
import fpml.confirmation.InstrumentTradeQuantity;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.InstrumentTradeDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to hold trades of multiply-traded instruments such as securities (e.g., stocks or bonds) or listed derivatives. Typically this will be used to represent the trade resulting from a physically-settled OTC product where the underlying is a security, for example the exercise of a physically-settled option. The economics of a trade of a multiply traded instrument.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InstrumentTradeDetails", builder=InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InstrumentTradeDetails extends Product {

	InstrumentTradeDetailsMeta metaData = new InstrumentTradeDetailsMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	Asset getUnderlyingAsset();
	/**
	 * A description of how much of the instrument was traded.
	 */
	InstrumentTradeQuantity getQuantity();
	/**
	 * The price paid for the instrument.
	 */
	InstrumentTradePricing getPricing();
	/**
	 * The value, in instrument currency, of the amount of the instrument that was traded.
	 */
	InstrumentTradePrincipal getPrincipal();

	/*********************** Build Methods  ***********************/
	InstrumentTradeDetails build();
	
	InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder();
	
	static InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder() {
		return new InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradeDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentTradeDetails> getType() {
		return InstrumentTradeDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("quantity"), processor, InstrumentTradeQuantity.class, getQuantity());
		processRosetta(path.newSubPath("pricing"), processor, InstrumentTradePricing.class, getPricing());
		processRosetta(path.newSubPath("principal"), processor, InstrumentTradePrincipal.class, getPrincipal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradeDetailsBuilder extends InstrumentTradeDetails, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getOrCreateQuantity();
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getQuantity();
		InstrumentTradePricing.InstrumentTradePricingBuilder getOrCreatePricing();
		InstrumentTradePricing.InstrumentTradePricingBuilder getPricing();
		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getOrCreatePrincipal();
		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getPrincipal();
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductModel(ProductModel productModel);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setId(String id);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setUnderlyingAsset(Asset underlyingAsset);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setQuantity(InstrumentTradeQuantity quantity);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPricing(InstrumentTradePricing pricing);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrincipal(InstrumentTradePrincipal principal);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("quantity"), processor, InstrumentTradeQuantity.InstrumentTradeQuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("pricing"), processor, InstrumentTradePricing.InstrumentTradePricingBuilder.class, getPricing());
			processRosetta(path.newSubPath("principal"), processor, InstrumentTradePrincipal.InstrumentTradePrincipalBuilder.class, getPrincipal());
		}
		

		InstrumentTradeDetails.InstrumentTradeDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradeDetails  ***********************/
	class InstrumentTradeDetailsImpl extends Product.ProductImpl implements InstrumentTradeDetails {
		private final BuyerSellerModel buyerSellerModel;
		private final Asset underlyingAsset;
		private final InstrumentTradeQuantity quantity;
		private final InstrumentTradePricing pricing;
		private final InstrumentTradePrincipal principal;
		
		protected InstrumentTradeDetailsImpl(InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.pricing = ofNullable(builder.getPricing()).map(f->f.build()).orElse(null);
			this.principal = ofNullable(builder.getPrincipal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public InstrumentTradeQuantity getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("pricing")
		public InstrumentTradePricing getPricing() {
			return pricing;
		}
		
		@Override
		@RosettaAttribute("principal")
		public InstrumentTradePrincipal getPrincipal() {
			return principal;
		}
		
		@Override
		public InstrumentTradeDetails build() {
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder() {
			InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getPricing()).ifPresent(builder::setPricing);
			ofNullable(getPrincipal()).ifPresent(builder::setPrincipal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentTradeDetails _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(pricing, _that.getPricing())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (pricing != null ? pricing.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeDetails {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quantity=" + this.quantity + ", " +
				"pricing=" + this.pricing + ", " +
				"principal=" + this.principal +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InstrumentTradeDetails  ***********************/
	class InstrumentTradeDetailsBuilderImpl extends Product.ProductBuilderImpl  implements InstrumentTradeDetails.InstrumentTradeDetailsBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected Asset.AssetBuilder underlyingAsset;
		protected InstrumentTradeQuantity.InstrumentTradeQuantityBuilder quantity;
		protected InstrumentTradePricing.InstrumentTradePricingBuilder pricing;
		protected InstrumentTradePrincipal.InstrumentTradePrincipalBuilder principal;
	
		public InstrumentTradeDetailsBuilderImpl() {
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
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getOrCreateQuantity() {
			InstrumentTradeQuantity.InstrumentTradeQuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = InstrumentTradeQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricing")
		public InstrumentTradePricing.InstrumentTradePricingBuilder getPricing() {
			return pricing;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder getOrCreatePricing() {
			InstrumentTradePricing.InstrumentTradePricingBuilder result;
			if (pricing!=null) {
				result = pricing;
			}
			else {
				result = pricing = InstrumentTradePricing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principal")
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getPrincipal() {
			return principal;
		}
		
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getOrCreatePrincipal() {
			InstrumentTradePrincipal.InstrumentTradePrincipalBuilder result;
			if (principal!=null) {
				result = principal;
			}
			else {
				result = principal = InstrumentTradePrincipal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyingAsset")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setQuantity(InstrumentTradeQuantity quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricing")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPricing(InstrumentTradePricing pricing) {
			this.pricing = pricing==null?null:pricing.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principal")
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrincipal(InstrumentTradePrincipal principal) {
			this.principal = principal==null?null:principal.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentTradeDetails build() {
			return new InstrumentTradeDetails.InstrumentTradeDetailsImpl(this);
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (pricing!=null && !pricing.prune().hasData()) pricing = null;
			if (principal!=null && !principal.prune().hasData()) principal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getPricing()!=null && getPricing().hasData()) return true;
			if (getPrincipal()!=null && getPrincipal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InstrumentTradeDetails.InstrumentTradeDetailsBuilder o = (InstrumentTradeDetails.InstrumentTradeDetailsBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getPricing(), o.getPricing(), this::setPricing);
			merger.mergeRosetta(getPrincipal(), o.getPrincipal(), this::setPrincipal);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentTradeDetails _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(pricing, _that.getPricing())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (pricing != null ? pricing.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeDetailsBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quantity=" + this.quantity + ", " +
				"pricing=" + this.pricing + ", " +
				"principal=" + this.principal +
			'}' + " " + super.toString();
		}
	}
}
