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
import fpml.confirmation.IssuerId;
import fpml.confirmation.ProductComponentIdentifier;
import fpml.confirmation.ProductComponentIdentifier.ProductComponentIdentifierBuilder;
import fpml.confirmation.ProductComponentIdentifier.ProductComponentIdentifierBuilderImpl;
import fpml.confirmation.ProductComponentIdentifier.ProductComponentIdentifierImpl;
import fpml.confirmation.ProductReference;
import fpml.confirmation.TradeId;
import fpml.confirmation.meta.ProductComponentIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Deprecated: A type defining a USI for the a subproduct component of a strategy.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ProductComponentIdentifier", builder=ProductComponentIdentifier.ProductComponentIdentifierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ProductComponentIdentifier extends RosettaModelObject {

	ProductComponentIdentifierMeta metaData = new ProductComponentIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates which product within a strategy this ID is associated with.
	 */
	ProductReference getPremiumProductReference();
	IssuerId getIssuer();
	TradeId getTradeId();

	/*********************** Build Methods  ***********************/
	ProductComponentIdentifier build();
	
	ProductComponentIdentifier.ProductComponentIdentifierBuilder toBuilder();
	
	static ProductComponentIdentifier.ProductComponentIdentifierBuilder builder() {
		return new ProductComponentIdentifier.ProductComponentIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductComponentIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProductComponentIdentifier> getType() {
		return ProductComponentIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.class, getPremiumProductReference());
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductComponentIdentifierBuilder extends ProductComponentIdentifier, RosettaModelObjectBuilder {
		ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference();
		ProductReference.ProductReferenceBuilder getPremiumProductReference();
		IssuerId.IssuerIdBuilder getOrCreateIssuer();
		IssuerId.IssuerIdBuilder getIssuer();
		TradeId.TradeIdBuilder getOrCreateTradeId();
		TradeId.TradeIdBuilder getTradeId();
		ProductComponentIdentifier.ProductComponentIdentifierBuilder setPremiumProductReference(ProductReference premiumProductReference);
		ProductComponentIdentifier.ProductComponentIdentifierBuilder setIssuer(IssuerId issuer);
		ProductComponentIdentifier.ProductComponentIdentifierBuilder setTradeId(TradeId tradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.ProductReferenceBuilder.class, getPremiumProductReference());
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
		}
		

		ProductComponentIdentifier.ProductComponentIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ProductComponentIdentifier  ***********************/
	class ProductComponentIdentifierImpl implements ProductComponentIdentifier {
		private final ProductReference premiumProductReference;
		private final IssuerId issuer;
		private final TradeId tradeId;
		
		protected ProductComponentIdentifierImpl(ProductComponentIdentifier.ProductComponentIdentifierBuilder builder) {
			this.premiumProductReference = ofNullable(builder.getPremiumProductReference()).map(f->f.build()).orElse(null);
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		public ProductReference getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		@RosettaAttribute("issuer")
		public IssuerId getIssuer() {
			return issuer;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		public ProductComponentIdentifier build() {
			return this;
		}
		
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder toBuilder() {
			ProductComponentIdentifier.ProductComponentIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductComponentIdentifier.ProductComponentIdentifierBuilder builder) {
			ofNullable(getPremiumProductReference()).ifPresent(builder::setPremiumProductReference);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductComponentIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductComponentIdentifier {" +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductComponentIdentifier  ***********************/
	class ProductComponentIdentifierBuilderImpl implements ProductComponentIdentifier.ProductComponentIdentifierBuilder {
	
		protected ProductReference.ProductReferenceBuilder premiumProductReference;
		protected IssuerId.IssuerIdBuilder issuer;
		protected TradeId.TradeIdBuilder tradeId;
	
		public ProductComponentIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("premiumProductReference")
		public ProductReference.ProductReferenceBuilder getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference() {
			ProductReference.ProductReferenceBuilder result;
			if (premiumProductReference!=null) {
				result = premiumProductReference;
			}
			else {
				result = premiumProductReference = ProductReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuer")
		public IssuerId.IssuerIdBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerId.IssuerIdBuilder getOrCreateIssuer() {
			IssuerId.IssuerIdBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = IssuerId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder setPremiumProductReference(ProductReference premiumProductReference) {
			this.premiumProductReference = premiumProductReference==null?null:premiumProductReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("issuer")
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder setIssuer(IssuerId issuer) {
			this.issuer = issuer==null?null:issuer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeId")
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder setTradeId(TradeId tradeId) {
			this.tradeId = tradeId==null?null:tradeId.toBuilder();
			return this;
		}
		
		@Override
		public ProductComponentIdentifier build() {
			return new ProductComponentIdentifier.ProductComponentIdentifierImpl(this);
		}
		
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder prune() {
			if (premiumProductReference!=null && !premiumProductReference.prune().hasData()) premiumProductReference = null;
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPremiumProductReference()!=null && getPremiumProductReference().hasData()) return true;
			if (getIssuer()!=null && getIssuer().hasData()) return true;
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductComponentIdentifier.ProductComponentIdentifierBuilder o = (ProductComponentIdentifier.ProductComponentIdentifierBuilder) other;
			
			merger.mergeRosetta(getPremiumProductReference(), o.getPremiumProductReference(), this::setPremiumProductReference);
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductComponentIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductComponentIdentifierBuilder {" +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}
}
