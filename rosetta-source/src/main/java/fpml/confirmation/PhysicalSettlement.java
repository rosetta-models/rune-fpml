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
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.PhysicalSettlement.PhysicalSettlementBuilder;
import fpml.confirmation.PhysicalSettlement.PhysicalSettlementBuilderImpl;
import fpml.confirmation.PhysicalSettlement.PhysicalSettlementImpl;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.PhysicalSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that describes how an option settles into a physical trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PhysicalSettlement", builder=PhysicalSettlement.PhysicalSettlementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PhysicalSettlement extends RosettaModelObject {

	PhysicalSettlementMeta metaData = new PhysicalSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The ID of the trade that resulted from the physical settlement.
	 */
	PartyTradeIdentifier getResultingTradeIdentifier();
	/**
	 * The trade that resulted from the physical settlement.
	 */
	Trade getResultingTrade();
	Product getProduct();

	/*********************** Build Methods  ***********************/
	PhysicalSettlement build();
	
	PhysicalSettlement.PhysicalSettlementBuilder toBuilder();
	
	static PhysicalSettlement.PhysicalSettlementBuilder builder() {
		return new PhysicalSettlement.PhysicalSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PhysicalSettlement> getType() {
		return PhysicalSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("resultingTradeIdentifier"), processor, PartyTradeIdentifier.class, getResultingTradeIdentifier());
		processRosetta(path.newSubPath("resultingTrade"), processor, Trade.class, getResultingTrade());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalSettlementBuilder extends PhysicalSettlement, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateResultingTradeIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getResultingTradeIdentifier();
		Trade.TradeBuilder getOrCreateResultingTrade();
		Trade.TradeBuilder getResultingTrade();
		Product.ProductBuilder getOrCreateProduct();
		Product.ProductBuilder getProduct();
		PhysicalSettlement.PhysicalSettlementBuilder setResultingTradeIdentifier(PartyTradeIdentifier resultingTradeIdentifier);
		PhysicalSettlement.PhysicalSettlementBuilder setResultingTrade(Trade resultingTrade);
		PhysicalSettlement.PhysicalSettlementBuilder setProduct(Product product);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("resultingTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getResultingTradeIdentifier());
			processRosetta(path.newSubPath("resultingTrade"), processor, Trade.TradeBuilder.class, getResultingTrade());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
		}
		

		PhysicalSettlement.PhysicalSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalSettlement  ***********************/
	class PhysicalSettlementImpl implements PhysicalSettlement {
		private final PartyTradeIdentifier resultingTradeIdentifier;
		private final Trade resultingTrade;
		private final Product product;
		
		protected PhysicalSettlementImpl(PhysicalSettlement.PhysicalSettlementBuilder builder) {
			this.resultingTradeIdentifier = ofNullable(builder.getResultingTradeIdentifier()).map(f->f.build()).orElse(null);
			this.resultingTrade = ofNullable(builder.getResultingTrade()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("resultingTradeIdentifier")
		public PartyTradeIdentifier getResultingTradeIdentifier() {
			return resultingTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		public Trade getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		@RosettaAttribute("product")
		public Product getProduct() {
			return product;
		}
		
		@Override
		public PhysicalSettlement build() {
			return this;
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder toBuilder() {
			PhysicalSettlement.PhysicalSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalSettlement.PhysicalSettlementBuilder builder) {
			ofNullable(getResultingTradeIdentifier()).ifPresent(builder::setResultingTradeIdentifier);
			ofNullable(getResultingTrade()).ifPresent(builder::setResultingTrade);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(resultingTradeIdentifier, _that.getResultingTradeIdentifier())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resultingTradeIdentifier != null ? resultingTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlement {" +
				"resultingTradeIdentifier=" + this.resultingTradeIdentifier + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"product=" + this.product +
			'}';
		}
	}

	/*********************** Builder Implementation of PhysicalSettlement  ***********************/
	class PhysicalSettlementBuilderImpl implements PhysicalSettlement.PhysicalSettlementBuilder {
	
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder resultingTradeIdentifier;
		protected Trade.TradeBuilder resultingTrade;
		protected Product.ProductBuilder product;
	
		public PhysicalSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("resultingTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getResultingTradeIdentifier() {
			return resultingTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateResultingTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (resultingTradeIdentifier!=null) {
				result = resultingTradeIdentifier;
			}
			else {
				result = resultingTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		public Trade.TradeBuilder getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateResultingTrade() {
			Trade.TradeBuilder result;
			if (resultingTrade!=null) {
				result = resultingTrade;
			}
			else {
				result = resultingTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resultingTradeIdentifier")
		public PhysicalSettlement.PhysicalSettlementBuilder setResultingTradeIdentifier(PartyTradeIdentifier resultingTradeIdentifier) {
			this.resultingTradeIdentifier = resultingTradeIdentifier==null?null:resultingTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resultingTrade")
		public PhysicalSettlement.PhysicalSettlementBuilder setResultingTrade(Trade resultingTrade) {
			this.resultingTrade = resultingTrade==null?null:resultingTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("product")
		public PhysicalSettlement.PhysicalSettlementBuilder setProduct(Product product) {
			this.product = product==null?null:product.toBuilder();
			return this;
		}
		
		@Override
		public PhysicalSettlement build() {
			return new PhysicalSettlement.PhysicalSettlementImpl(this);
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder prune() {
			if (resultingTradeIdentifier!=null && !resultingTradeIdentifier.prune().hasData()) resultingTradeIdentifier = null;
			if (resultingTrade!=null && !resultingTrade.prune().hasData()) resultingTrade = null;
			if (product!=null && !product.prune().hasData()) product = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResultingTradeIdentifier()!=null && getResultingTradeIdentifier().hasData()) return true;
			if (getResultingTrade()!=null && getResultingTrade().hasData()) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PhysicalSettlement.PhysicalSettlementBuilder o = (PhysicalSettlement.PhysicalSettlementBuilder) other;
			
			merger.mergeRosetta(getResultingTradeIdentifier(), o.getResultingTradeIdentifier(), this::setResultingTradeIdentifier);
			merger.mergeRosetta(getResultingTrade(), o.getResultingTrade(), this::setResultingTrade);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(resultingTradeIdentifier, _that.getResultingTradeIdentifier())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resultingTradeIdentifier != null ? resultingTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementBuilder {" +
				"resultingTradeIdentifier=" + this.resultingTradeIdentifier + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"product=" + this.product +
			'}';
		}
	}
}
