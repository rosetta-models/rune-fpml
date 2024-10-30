package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilder;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilderImpl;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeImpl;
import cdm.base.staticdata.asset.common.PutCallEnum;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.meta.ListedDerivativeMeta;
import cdm.base.staticdata.party.LegalEntity;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A securitized derivative on another asset.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="ListedDerivative", builder=ListedDerivative.ListedDerivativeBuilderImpl.class, version="6.0.0-dev.76")
public interface ListedDerivative extends InstrumentBase {

	ListedDerivativeMeta metaData = new ListedDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Also called contract month or delivery month. However, it&#39;s not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
	 */
	String getDeliveryTerm();
	/**
	 * The type of option, ie Put or Call. Left empty if it is a Future.
	 */
	PutCallEnum getOptionType();
	/**
	 * Specifies the strike of the option.
	 */
	BigDecimal getStrike();

	/*********************** Build Methods  ***********************/
	ListedDerivative build();
	
	ListedDerivative.ListedDerivativeBuilder toBuilder();
	
	static ListedDerivative.ListedDerivativeBuilder builder() {
		return new ListedDerivative.ListedDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ListedDerivative> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ListedDerivative> getType() {
		return ListedDerivative.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ListedDerivativeBuilder extends ListedDerivative, InstrumentBase.InstrumentBaseBuilder {
		ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier0);
		ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		ListedDerivative.ListedDerivativeBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		ListedDerivative.ListedDerivativeBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy0);
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		ListedDerivative.ListedDerivativeBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		ListedDerivative.ListedDerivativeBuilder setIsExchangeListed(Boolean isExchangeListed);
		ListedDerivative.ListedDerivativeBuilder setExchange(LegalEntity exchange);
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange0);
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		ListedDerivative.ListedDerivativeBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		ListedDerivative.ListedDerivativeBuilder setDeliveryTerm(String deliveryTerm);
		ListedDerivative.ListedDerivativeBuilder setOptionType(PutCallEnum optionType);
		ListedDerivative.ListedDerivativeBuilder setStrike(BigDecimal strike);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		}
		

		ListedDerivative.ListedDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of ListedDerivative  ***********************/
	class ListedDerivativeImpl extends InstrumentBase.InstrumentBaseImpl implements ListedDerivative {
		private final String deliveryTerm;
		private final PutCallEnum optionType;
		private final BigDecimal strike;
		
		protected ListedDerivativeImpl(ListedDerivative.ListedDerivativeBuilder builder) {
			super(builder);
			this.deliveryTerm = builder.getDeliveryTerm();
			this.optionType = builder.getOptionType();
			this.strike = builder.getStrike();
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		public ListedDerivative build() {
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder toBuilder() {
			ListedDerivative.ListedDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ListedDerivative.ListedDerivativeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryTerm()).ifPresent(builder::setDeliveryTerm);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ListedDerivative _that = getType().cast(o);
		
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListedDerivative {" +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ListedDerivative  ***********************/
	class ListedDerivativeBuilderImpl extends InstrumentBase.InstrumentBaseBuilderImpl  implements ListedDerivative.ListedDerivativeBuilder {
	
		protected String deliveryTerm;
		protected PutCallEnum optionType;
		protected BigDecimal strike;
	
		public ListedDerivativeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null)  {
				this.taxonomy = new ArrayList<>();
			}
			else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		public ListedDerivative.ListedDerivativeBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public ListedDerivative.ListedDerivativeBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null)  {
				this.relatedExchange = new ArrayList<>();
			}
			else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		public ListedDerivative.ListedDerivativeBuilder setDeliveryTerm(String deliveryTerm) {
			this.deliveryTerm = deliveryTerm==null?null:deliveryTerm;
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public ListedDerivative.ListedDerivativeBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public ListedDerivative.ListedDerivativeBuilder setStrike(BigDecimal strike) {
			this.strike = strike==null?null:strike;
			return this;
		}
		
		@Override
		public ListedDerivative build() {
			return new ListedDerivative.ListedDerivativeImpl(this);
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListedDerivative.ListedDerivativeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryTerm()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getStrike()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListedDerivative.ListedDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ListedDerivative.ListedDerivativeBuilder o = (ListedDerivative.ListedDerivativeBuilder) other;
			
			
			merger.mergeBasic(getDeliveryTerm(), o.getDeliveryTerm(), this::setDeliveryTerm);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ListedDerivative _that = getType().cast(o);
		
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListedDerivativeBuilder {" +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}
}
