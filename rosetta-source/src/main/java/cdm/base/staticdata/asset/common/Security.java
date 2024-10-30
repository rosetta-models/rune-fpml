package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.EquityTypeEnum;
import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Security.SecurityBuilder;
import cdm.base.staticdata.asset.common.Security.SecurityBuilderImpl;
import cdm.base.staticdata.asset.common.Security.SecurityImpl;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.meta.SecurityMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a security by referencing an identifier and by specifying the sector.
 * @version 6.0.0-dev.76
 *
 * Body ICMA
 * Corpus MasterAgreement GMRA Global Master Repurchase Agreement GMRA 2011 "The Global Master Repurchase Agreement (GMRA) is a model legal agreement designed for parties transacting repos and is published by the International Capital Market Association (ICMA)." 
 * namingConvention "Purchased Security"
 *
 * Provision As defined in GMRA paragraph 2(oo) The Purchased Securities are the Securities sold or to be sold and any New Purchased Securities transferred by Seller to Buyer under paragraph 8 (Substitution).
 *
 */
@RosettaDataType(value="Security", builder=Security.SecurityBuilderImpl.class, version="6.0.0-dev.76")
public interface Security extends InstrumentBase {

	SecurityMeta metaData = new SecurityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the type of security using an enumerated list.
	 */
	SecurityTypeEnum getSecurityType();
	/**
	 * Identifies the type of debt and selected debt economics.
	 */
	DebtType getDebtType();
	/**
	 * Identifies the type of equity.
	 */
	EquityTypeEnum getEquityType();
	/**
	 * Identifies the type of fund.
	 */
	FundProductTypeEnum getFundType();

	/*********************** Build Methods  ***********************/
	Security build();
	
	Security.SecurityBuilder toBuilder();
	
	static Security.SecurityBuilder builder() {
		return new Security.SecurityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Security> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Security> getType() {
		return Security.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
		processRosetta(path.newSubPath("debtType"), processor, DebtType.class, getDebtType());
		processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
		processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityBuilder extends Security, InstrumentBase.InstrumentBaseBuilder {
		DebtType.DebtTypeBuilder getOrCreateDebtType();
		DebtType.DebtTypeBuilder getDebtType();
		Security.SecurityBuilder addIdentifier(AssetIdentifier identifier0);
		Security.SecurityBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		Security.SecurityBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		Security.SecurityBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy0);
		Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		Security.SecurityBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		Security.SecurityBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		Security.SecurityBuilder setIsExchangeListed(Boolean isExchangeListed);
		Security.SecurityBuilder setExchange(LegalEntity exchange);
		Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange0);
		Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		Security.SecurityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		Security.SecurityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		Security.SecurityBuilder setSecurityType(SecurityTypeEnum securityType);
		Security.SecurityBuilder setDebtType(DebtType debtType);
		Security.SecurityBuilder setEquityType(EquityTypeEnum equityType);
		Security.SecurityBuilder setFundType(FundProductTypeEnum fundType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
			processRosetta(path.newSubPath("debtType"), processor, DebtType.DebtTypeBuilder.class, getDebtType());
			processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
			processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
		}
		

		Security.SecurityBuilder prune();
	}

	/*********************** Immutable Implementation of Security  ***********************/
	class SecurityImpl extends InstrumentBase.InstrumentBaseImpl implements Security {
		private final SecurityTypeEnum securityType;
		private final DebtType debtType;
		private final EquityTypeEnum equityType;
		private final FundProductTypeEnum fundType;
		
		protected SecurityImpl(Security.SecurityBuilder builder) {
			super(builder);
			this.securityType = builder.getSecurityType();
			this.debtType = ofNullable(builder.getDebtType()).map(f->f.build()).orElse(null);
			this.equityType = builder.getEquityType();
			this.fundType = builder.getFundType();
		}
		
		@Override
		@RosettaAttribute("securityType")
		public SecurityTypeEnum getSecurityType() {
			return securityType;
		}
		
		@Override
		@RosettaAttribute("debtType")
		public DebtType getDebtType() {
			return debtType;
		}
		
		@Override
		@RosettaAttribute("equityType")
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		@RosettaAttribute("fundType")
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		public Security build() {
			return this;
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			Security.SecurityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Security.SecurityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSecurityType()).ifPresent(builder::setSecurityType);
			ofNullable(getDebtType()).ifPresent(builder::setDebtType);
			ofNullable(getEquityType()).ifPresent(builder::setEquityType);
			ofNullable(getFundType()).ifPresent(builder::setFundType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Security {" +
				"securityType=" + this.securityType + ", " +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Security  ***********************/
	class SecurityBuilderImpl extends InstrumentBase.InstrumentBaseBuilderImpl  implements Security.SecurityBuilder {
	
		protected SecurityTypeEnum securityType;
		protected DebtType.DebtTypeBuilder debtType;
		protected EquityTypeEnum equityType;
		protected FundProductTypeEnum fundType;
	
		public SecurityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("securityType")
		public SecurityTypeEnum getSecurityType() {
			return securityType;
		}
		
		@Override
		@RosettaAttribute("debtType")
		public DebtType.DebtTypeBuilder getDebtType() {
			return debtType;
		}
		
		@Override
		public DebtType.DebtTypeBuilder getOrCreateDebtType() {
			DebtType.DebtTypeBuilder result;
			if (debtType!=null) {
				result = debtType;
			}
			else {
				result = debtType = DebtType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityType")
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		@RosettaAttribute("fundType")
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public Security.SecurityBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public Security.SecurityBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public Security.SecurityBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Security.SecurityBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public Security.SecurityBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public Security.SecurityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		@RosettaAttribute("securityType")
		public Security.SecurityBuilder setSecurityType(SecurityTypeEnum securityType) {
			this.securityType = securityType==null?null:securityType;
			return this;
		}
		@Override
		@RosettaAttribute("debtType")
		public Security.SecurityBuilder setDebtType(DebtType debtType) {
			this.debtType = debtType==null?null:debtType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityType")
		public Security.SecurityBuilder setEquityType(EquityTypeEnum equityType) {
			this.equityType = equityType==null?null:equityType;
			return this;
		}
		@Override
		@RosettaAttribute("fundType")
		public Security.SecurityBuilder setFundType(FundProductTypeEnum fundType) {
			this.fundType = fundType==null?null:fundType;
			return this;
		}
		
		@Override
		public Security build() {
			return new Security.SecurityImpl(this);
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder prune() {
			super.prune();
			if (debtType!=null && !debtType.prune().hasData()) debtType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSecurityType()!=null) return true;
			if (getDebtType()!=null && getDebtType().hasData()) return true;
			if (getEquityType()!=null) return true;
			if (getFundType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Security.SecurityBuilder o = (Security.SecurityBuilder) other;
			
			merger.mergeRosetta(getDebtType(), o.getDebtType(), this::setDebtType);
			
			merger.mergeBasic(getSecurityType(), o.getSecurityType(), this::setSecurityType);
			merger.mergeBasic(getEquityType(), o.getEquityType(), this::setEquityType);
			merger.mergeBasic(getFundType(), o.getFundType(), this::setFundType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityBuilder {" +
				"securityType=" + this.securityType + ", " +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType +
			'}' + " " + super.toString();
		}
	}
}
