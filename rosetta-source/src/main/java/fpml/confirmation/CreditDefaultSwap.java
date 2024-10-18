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
import fpml.confirmation.CreditDefaultSwap;
import fpml.confirmation.CreditDefaultSwap.CreditDefaultSwapBuilder;
import fpml.confirmation.CreditDefaultSwap.CreditDefaultSwapBuilderImpl;
import fpml.confirmation.CreditDefaultSwap.CreditDefaultSwapImpl;
import fpml.confirmation.CreditDefaultSwapChoice;
import fpml.confirmation.FeeLeg;
import fpml.confirmation.GeneralTerms;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ProtectionTerms;
import fpml.confirmation.meta.CreditDefaultSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * In a credit default swap one party (the protection seller) agrees to compensate another party (the protection buyer) if a specified company or Sovereign (the reference entity) experiences a credit event, indicating it is or may be unable to service its debts. The protection seller is typically paid a fee and/or premium, expressed as an annualized percent of the notional in basis points, regularly over the life of the transaction or otherwise as agreed by the parties.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditDefaultSwap", builder=CreditDefaultSwap.CreditDefaultSwapBuilderImpl.class, version="${project.version}")
public interface CreditDefaultSwap extends Product {

	CreditDefaultSwapMeta metaData = new CreditDefaultSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This element contains all the data that appears in the section entitled &quot;1. General Terms&quot; in the 2003 ISDA Credit Derivatives Confirmation.
	 */
	GeneralTerms getGeneralTerms();
	/**
	 * This element contains all the terms relevant to defining the fixed amounts/payments per the applicable ISDA definitions.
	 */
	FeeLeg getFeeLeg();
	/**
	 * This element contains all the terms relevant to defining the applicable floating rate payer calculation amount, credit events and associated conditions to settlement, and reference obligations.
	 */
	List<? extends ProtectionTerms> getProtectionTerms();
	List<? extends CreditDefaultSwapChoice> getCreditDefaultSwapChoice();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwap build();
	
	CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder();
	
	static CreditDefaultSwap.CreditDefaultSwapBuilder builder() {
		return new CreditDefaultSwap.CreditDefaultSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditDefaultSwap> getType() {
		return CreditDefaultSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.class, getGeneralTerms());
		processRosetta(path.newSubPath("feeLeg"), processor, FeeLeg.class, getFeeLeg());
		processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.class, getProtectionTerms());
		processRosetta(path.newSubPath("creditDefaultSwapChoice"), processor, CreditDefaultSwapChoice.class, getCreditDefaultSwapChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapBuilder extends CreditDefaultSwap, Product.ProductBuilder {
		GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms();
		GeneralTerms.GeneralTermsBuilder getGeneralTerms();
		FeeLeg.FeeLegBuilder getOrCreateFeeLeg();
		FeeLeg.FeeLegBuilder getFeeLeg();
		ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index);
		List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms();
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder getOrCreateCreditDefaultSwapChoice(int _index);
		List<? extends CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> getCreditDefaultSwapChoice();
		CreditDefaultSwap.CreditDefaultSwapBuilder setProductModel(ProductModel productModel);
		CreditDefaultSwap.CreditDefaultSwapBuilder setId(String id);
		CreditDefaultSwap.CreditDefaultSwapBuilder setGeneralTerms(GeneralTerms generalTerms);
		CreditDefaultSwap.CreditDefaultSwapBuilder setFeeLeg(FeeLeg feeLeg);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms0);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms1, int _idx);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTerms2);
		CreditDefaultSwap.CreditDefaultSwapBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTerms3);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice0);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice1, int _idx);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice2);
		CreditDefaultSwap.CreditDefaultSwapBuilder setCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.GeneralTermsBuilder.class, getGeneralTerms());
			processRosetta(path.newSubPath("feeLeg"), processor, FeeLeg.FeeLegBuilder.class, getFeeLeg());
			processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.ProtectionTermsBuilder.class, getProtectionTerms());
			processRosetta(path.newSubPath("creditDefaultSwapChoice"), processor, CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder.class, getCreditDefaultSwapChoice());
		}
		

		CreditDefaultSwap.CreditDefaultSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwap  ***********************/
	class CreditDefaultSwapImpl extends Product.ProductImpl implements CreditDefaultSwap {
		private final GeneralTerms generalTerms;
		private final FeeLeg feeLeg;
		private final List<? extends ProtectionTerms> protectionTerms;
		private final List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice;
		
		protected CreditDefaultSwapImpl(CreditDefaultSwap.CreditDefaultSwapBuilder builder) {
			super(builder);
			this.generalTerms = ofNullable(builder.getGeneralTerms()).map(f->f.build()).orElse(null);
			this.feeLeg = ofNullable(builder.getFeeLeg()).map(f->f.build()).orElse(null);
			this.protectionTerms = ofNullable(builder.getProtectionTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDefaultSwapChoice = ofNullable(builder.getCreditDefaultSwapChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("generalTerms")
		public GeneralTerms getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		@RosettaAttribute("feeLeg")
		public FeeLeg getFeeLeg() {
			return feeLeg;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		public List<? extends ProtectionTerms> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwapChoice")
		public List<? extends CreditDefaultSwapChoice> getCreditDefaultSwapChoice() {
			return creditDefaultSwapChoice;
		}
		
		@Override
		public CreditDefaultSwap build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder() {
			CreditDefaultSwap.CreditDefaultSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwap.CreditDefaultSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGeneralTerms()).ifPresent(builder::setGeneralTerms);
			ofNullable(getFeeLeg()).ifPresent(builder::setFeeLeg);
			ofNullable(getProtectionTerms()).ifPresent(builder::setProtectionTerms);
			ofNullable(getCreditDefaultSwapChoice()).ifPresent(builder::setCreditDefaultSwapChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(feeLeg, _that.getFeeLeg())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!ListEquals.listEquals(creditDefaultSwapChoice, _that.getCreditDefaultSwapChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (feeLeg != null ? feeLeg.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwapChoice != null ? creditDefaultSwapChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwap {" +
				"generalTerms=" + this.generalTerms + ", " +
				"feeLeg=" + this.feeLeg + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"creditDefaultSwapChoice=" + this.creditDefaultSwapChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwap  ***********************/
	class CreditDefaultSwapBuilderImpl extends Product.ProductBuilderImpl  implements CreditDefaultSwap.CreditDefaultSwapBuilder {
	
		protected GeneralTerms.GeneralTermsBuilder generalTerms;
		protected FeeLeg.FeeLegBuilder feeLeg;
		protected List<ProtectionTerms.ProtectionTermsBuilder> protectionTerms = new ArrayList<>();
		protected List<CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> creditDefaultSwapChoice = new ArrayList<>();
	
		public CreditDefaultSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("generalTerms")
		public GeneralTerms.GeneralTermsBuilder getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms() {
			GeneralTerms.GeneralTermsBuilder result;
			if (generalTerms!=null) {
				result = generalTerms;
			}
			else {
				result = generalTerms = GeneralTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeLeg")
		public FeeLeg.FeeLegBuilder getFeeLeg() {
			return feeLeg;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder getOrCreateFeeLeg() {
			FeeLeg.FeeLegBuilder result;
			if (feeLeg!=null) {
				result = feeLeg;
			}
			else {
				result = feeLeg = FeeLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		public List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index) {
		
			if (protectionTerms==null) {
				this.protectionTerms = new ArrayList<>();
			}
			ProtectionTerms.ProtectionTermsBuilder result;
			return getIndex(protectionTerms, _index, () -> {
						ProtectionTerms.ProtectionTermsBuilder newProtectionTerms = ProtectionTerms.builder();
						return newProtectionTerms;
					});
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwapChoice")
		public List<? extends CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> getCreditDefaultSwapChoice() {
			return creditDefaultSwapChoice;
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder getOrCreateCreditDefaultSwapChoice(int _index) {
		
			if (creditDefaultSwapChoice==null) {
				this.creditDefaultSwapChoice = new ArrayList<>();
			}
			CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder result;
			return getIndex(creditDefaultSwapChoice, _index, () -> {
						CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder newCreditDefaultSwapChoice = CreditDefaultSwapChoice.builder();
						return newCreditDefaultSwapChoice;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CreditDefaultSwap.CreditDefaultSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CreditDefaultSwap.CreditDefaultSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("generalTerms")
		public CreditDefaultSwap.CreditDefaultSwapBuilder setGeneralTerms(GeneralTerms generalTerms) {
			this.generalTerms = generalTerms==null?null:generalTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeLeg")
		public CreditDefaultSwap.CreditDefaultSwapBuilder setFeeLeg(FeeLeg feeLeg) {
			this.feeLeg = feeLeg==null?null:feeLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("protectionTerms")
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms) {
			if (protectionTerms!=null) this.protectionTerms.add(protectionTerms.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms, int _idx) {
			getIndex(this.protectionTerms, _idx, () -> protectionTerms.toBuilder());
			return this;
		}
		@Override 
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss != null) {
				for (ProtectionTerms toAdd : protectionTermss) {
					this.protectionTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditDefaultSwap.CreditDefaultSwapBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss == null)  {
				this.protectionTerms = new ArrayList<>();
			}
			else {
				this.protectionTerms = protectionTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwapChoice")
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice) {
			if (creditDefaultSwapChoice!=null) this.creditDefaultSwapChoice.add(creditDefaultSwapChoice.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice, int _idx) {
			getIndex(this.creditDefaultSwapChoice, _idx, () -> creditDefaultSwapChoice.toBuilder());
			return this;
		}
		@Override 
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoices) {
			if (creditDefaultSwapChoices != null) {
				for (CreditDefaultSwapChoice toAdd : creditDefaultSwapChoices) {
					this.creditDefaultSwapChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditDefaultSwap.CreditDefaultSwapBuilder setCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoices) {
			if (creditDefaultSwapChoices == null)  {
				this.creditDefaultSwapChoice = new ArrayList<>();
			}
			else {
				this.creditDefaultSwapChoice = creditDefaultSwapChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CreditDefaultSwap build() {
			return new CreditDefaultSwap.CreditDefaultSwapImpl(this);
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder prune() {
			super.prune();
			if (generalTerms!=null && !generalTerms.prune().hasData()) generalTerms = null;
			if (feeLeg!=null && !feeLeg.prune().hasData()) feeLeg = null;
			protectionTerms = protectionTerms.stream().filter(b->b!=null).<ProtectionTerms.ProtectionTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditDefaultSwapChoice = creditDefaultSwapChoice.stream().filter(b->b!=null).<CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGeneralTerms()!=null && getGeneralTerms().hasData()) return true;
			if (getFeeLeg()!=null && getFeeLeg().hasData()) return true;
			if (getProtectionTerms()!=null && getProtectionTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDefaultSwapChoice()!=null && getCreditDefaultSwapChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditDefaultSwap.CreditDefaultSwapBuilder o = (CreditDefaultSwap.CreditDefaultSwapBuilder) other;
			
			merger.mergeRosetta(getGeneralTerms(), o.getGeneralTerms(), this::setGeneralTerms);
			merger.mergeRosetta(getFeeLeg(), o.getFeeLeg(), this::setFeeLeg);
			merger.mergeRosetta(getProtectionTerms(), o.getProtectionTerms(), this::getOrCreateProtectionTerms);
			merger.mergeRosetta(getCreditDefaultSwapChoice(), o.getCreditDefaultSwapChoice(), this::getOrCreateCreditDefaultSwapChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(feeLeg, _that.getFeeLeg())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!ListEquals.listEquals(creditDefaultSwapChoice, _that.getCreditDefaultSwapChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (feeLeg != null ? feeLeg.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwapChoice != null ? creditDefaultSwapChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapBuilder {" +
				"generalTerms=" + this.generalTerms + ", " +
				"feeLeg=" + this.feeLeg + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"creditDefaultSwapChoice=" + this.creditDefaultSwapChoice +
			'}' + " " + super.toString();
		}
	}
}
