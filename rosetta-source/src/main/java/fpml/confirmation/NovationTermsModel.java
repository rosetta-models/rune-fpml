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
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.ContractualTermsSupplement;
import fpml.confirmation.CreditDerivativesNotices;
import fpml.confirmation.Empty;
import fpml.confirmation.FirstPeriodStartDate;
import fpml.confirmation.NovationTermsModel;
import fpml.confirmation.NovationTermsModel.NovationTermsModelBuilder;
import fpml.confirmation.NovationTermsModel.NovationTermsModelBuilderImpl;
import fpml.confirmation.NovationTermsModel.NovationTermsModelImpl;
import fpml.confirmation.meta.NovationTermsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Documentation and other terms (such as date terms) specific to this novation event.
 * @version ${project.version}
 */
@RosettaDataType(value="NovationTermsModel", builder=NovationTermsModel.NovationTermsModelBuilderImpl.class, version="${project.version}")
public interface NovationTermsModel extends RosettaModelObject {

	NovationTermsModelMeta metaData = new NovationTermsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This element corresponds to the applicability of the Full First Calculation Period as defined in the 2004 ISDA Novation Definitions, section 1.20.
	 */
	Boolean getFullFirstCalculationPeriod();
	/**
	 * Element that is used to be able to make sense of the “new transaction” without requiring reference back to the “old transaction”. In the case of interest rate products there are potentially 2 “first period start dates” to reference – one with respect to each party to the new transaction. For Credit Default Swaps there is just the one with respect to the party that is the fixed rate payer.
	 */
	List<? extends FirstPeriodStartDate> getFirstPeriodStartDate();
	/**
	 * This element corresponds to the non-Reliance section in the 2004 ISDA Novation Definitions, section 2.1 (c) (i). The element appears in the instance document when non-Reliance is applicable.
	 */
	Empty getNonReliance();
	/**
	 * This element should be specified if one or more of either a Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party. The type of notice or notices that have been delivered should be indicated by setting the relevant boolean element value(s) to true. The absence of the element means that no Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party.
	 */
	CreditDerivativesNotices getCreditDerivativesNotices();
	/**
	 * The definitions (such as those published by ISDA) that will define the terms of the novation transaction.
	 */
	List<? extends ContractualDefinitions> getContractualDefinitions();
	/**
	 * A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();

	/*********************** Build Methods  ***********************/
	NovationTermsModel build();
	
	NovationTermsModel.NovationTermsModelBuilder toBuilder();
	
	static NovationTermsModel.NovationTermsModelBuilder builder() {
		return new NovationTermsModel.NovationTermsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationTermsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationTermsModel> getType() {
		return NovationTermsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fullFirstCalculationPeriod"), Boolean.class, getFullFirstCalculationPeriod(), this);
		processRosetta(path.newSubPath("firstPeriodStartDate"), processor, FirstPeriodStartDate.class, getFirstPeriodStartDate());
		processRosetta(path.newSubPath("nonReliance"), processor, Empty.class, getNonReliance());
		processRosetta(path.newSubPath("creditDerivativesNotices"), processor, CreditDerivativesNotices.class, getCreditDerivativesNotices());
		processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.class, getContractualDefinitions());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationTermsModelBuilder extends NovationTermsModel, RosettaModelObjectBuilder {
		FirstPeriodStartDate.FirstPeriodStartDateBuilder getOrCreateFirstPeriodStartDate(int _index);
		List<? extends FirstPeriodStartDate.FirstPeriodStartDateBuilder> getFirstPeriodStartDate();
		Empty.EmptyBuilder getOrCreateNonReliance();
		Empty.EmptyBuilder getNonReliance();
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder getOrCreateCreditDerivativesNotices();
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder getCreditDerivativesNotices();
		ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int _index);
		List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index);
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		NovationTermsModel.NovationTermsModelBuilder setFullFirstCalculationPeriod(Boolean fullFirstCalculationPeriod);
		NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate0);
		NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate1, int _idx);
		NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDate2);
		NovationTermsModel.NovationTermsModelBuilder setFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDate3);
		NovationTermsModel.NovationTermsModelBuilder setNonReliance(Empty nonReliance);
		NovationTermsModel.NovationTermsModelBuilder setCreditDerivativesNotices(CreditDerivativesNotices creditDerivativesNotices);
		NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions0);
		NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions1, int _idx);
		NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions2);
		NovationTermsModel.NovationTermsModelBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions3);
		NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement0);
		NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement1, int _idx);
		NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement2);
		NovationTermsModel.NovationTermsModelBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fullFirstCalculationPeriod"), Boolean.class, getFullFirstCalculationPeriod(), this);
			processRosetta(path.newSubPath("firstPeriodStartDate"), processor, FirstPeriodStartDate.FirstPeriodStartDateBuilder.class, getFirstPeriodStartDate());
			processRosetta(path.newSubPath("nonReliance"), processor, Empty.EmptyBuilder.class, getNonReliance());
			processRosetta(path.newSubPath("creditDerivativesNotices"), processor, CreditDerivativesNotices.CreditDerivativesNoticesBuilder.class, getCreditDerivativesNotices());
			processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.ContractualDefinitionsBuilder.class, getContractualDefinitions());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
		}
		

		NovationTermsModel.NovationTermsModelBuilder prune();
	}

	/*********************** Immutable Implementation of NovationTermsModel  ***********************/
	class NovationTermsModelImpl implements NovationTermsModel {
		private final Boolean fullFirstCalculationPeriod;
		private final List<? extends FirstPeriodStartDate> firstPeriodStartDate;
		private final Empty nonReliance;
		private final CreditDerivativesNotices creditDerivativesNotices;
		private final List<? extends ContractualDefinitions> contractualDefinitions;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		
		protected NovationTermsModelImpl(NovationTermsModel.NovationTermsModelBuilder builder) {
			this.fullFirstCalculationPeriod = builder.getFullFirstCalculationPeriod();
			this.firstPeriodStartDate = ofNullable(builder.getFirstPeriodStartDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.nonReliance = ofNullable(builder.getNonReliance()).map(f->f.build()).orElse(null);
			this.creditDerivativesNotices = ofNullable(builder.getCreditDerivativesNotices()).map(f->f.build()).orElse(null);
			this.contractualDefinitions = ofNullable(builder.getContractualDefinitions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fullFirstCalculationPeriod")
		public Boolean getFullFirstCalculationPeriod() {
			return fullFirstCalculationPeriod;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public List<? extends FirstPeriodStartDate> getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		public Empty getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("creditDerivativesNotices")
		public CreditDerivativesNotices getCreditDerivativesNotices() {
			return creditDerivativesNotices;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public NovationTermsModel build() {
			return this;
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder toBuilder() {
			NovationTermsModel.NovationTermsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationTermsModel.NovationTermsModelBuilder builder) {
			ofNullable(getFullFirstCalculationPeriod()).ifPresent(builder::setFullFirstCalculationPeriod);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getNonReliance()).ifPresent(builder::setNonReliance);
			ofNullable(getCreditDerivativesNotices()).ifPresent(builder::setCreditDerivativesNotices);
			ofNullable(getContractualDefinitions()).ifPresent(builder::setContractualDefinitions);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(fullFirstCalculationPeriod, _that.getFullFirstCalculationPeriod())) return false;
			if (!ListEquals.listEquals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(creditDerivativesNotices, _that.getCreditDerivativesNotices())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fullFirstCalculationPeriod != null ? fullFirstCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (creditDerivativesNotices != null ? creditDerivativesNotices.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationTermsModel {" +
				"fullFirstCalculationPeriod=" + this.fullFirstCalculationPeriod + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"nonReliance=" + this.nonReliance + ", " +
				"creditDerivativesNotices=" + this.creditDerivativesNotices + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationTermsModel  ***********************/
	class NovationTermsModelBuilderImpl implements NovationTermsModel.NovationTermsModelBuilder {
	
		protected Boolean fullFirstCalculationPeriod;
		protected List<FirstPeriodStartDate.FirstPeriodStartDateBuilder> firstPeriodStartDate = new ArrayList<>();
		protected Empty.EmptyBuilder nonReliance;
		protected CreditDerivativesNotices.CreditDerivativesNoticesBuilder creditDerivativesNotices;
		protected List<ContractualDefinitions.ContractualDefinitionsBuilder> contractualDefinitions = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
	
		public NovationTermsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fullFirstCalculationPeriod")
		public Boolean getFullFirstCalculationPeriod() {
			return fullFirstCalculationPeriod;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public List<? extends FirstPeriodStartDate.FirstPeriodStartDateBuilder> getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder getOrCreateFirstPeriodStartDate(int _index) {
		
			if (firstPeriodStartDate==null) {
				this.firstPeriodStartDate = new ArrayList<>();
			}
			FirstPeriodStartDate.FirstPeriodStartDateBuilder result;
			return getIndex(firstPeriodStartDate, _index, () -> {
						FirstPeriodStartDate.FirstPeriodStartDateBuilder newFirstPeriodStartDate = FirstPeriodStartDate.builder();
						return newFirstPeriodStartDate;
					});
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		public Empty.EmptyBuilder getNonReliance() {
			return nonReliance;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateNonReliance() {
			Empty.EmptyBuilder result;
			if (nonReliance!=null) {
				result = nonReliance;
			}
			else {
				result = nonReliance = Empty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditDerivativesNotices")
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder getCreditDerivativesNotices() {
			return creditDerivativesNotices;
		}
		
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder getOrCreateCreditDerivativesNotices() {
			CreditDerivativesNotices.CreditDerivativesNoticesBuilder result;
			if (creditDerivativesNotices!=null) {
				result = creditDerivativesNotices;
			}
			else {
				result = creditDerivativesNotices = CreditDerivativesNotices.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int _index) {
		
			if (contractualDefinitions==null) {
				this.contractualDefinitions = new ArrayList<>();
			}
			ContractualDefinitions.ContractualDefinitionsBuilder result;
			return getIndex(contractualDefinitions, _index, () -> {
						ContractualDefinitions.ContractualDefinitionsBuilder newContractualDefinitions = ContractualDefinitions.builder();
						return newContractualDefinitions;
					});
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index) {
		
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			ContractualTermsSupplement.ContractualTermsSupplementBuilder result;
			return getIndex(contractualTermsSupplement, _index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		@RosettaAttribute("fullFirstCalculationPeriod")
		public NovationTermsModel.NovationTermsModelBuilder setFullFirstCalculationPeriod(Boolean fullFirstCalculationPeriod) {
			this.fullFirstCalculationPeriod = fullFirstCalculationPeriod==null?null:fullFirstCalculationPeriod;
			return this;
		}
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate) {
			if (firstPeriodStartDate!=null) this.firstPeriodStartDate.add(firstPeriodStartDate.toBuilder());
			return this;
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate, int _idx) {
			getIndex(this.firstPeriodStartDate, _idx, () -> firstPeriodStartDate.toBuilder());
			return this;
		}
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder addFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDates) {
			if (firstPeriodStartDates != null) {
				for (FirstPeriodStartDate toAdd : firstPeriodStartDates) {
					this.firstPeriodStartDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder setFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDates) {
			if (firstPeriodStartDates == null)  {
				this.firstPeriodStartDate = new ArrayList<>();
			}
			else {
				this.firstPeriodStartDate = firstPeriodStartDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		public NovationTermsModel.NovationTermsModelBuilder setNonReliance(Empty nonReliance) {
			this.nonReliance = nonReliance==null?null:nonReliance.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditDerivativesNotices")
		public NovationTermsModel.NovationTermsModelBuilder setCreditDerivativesNotices(CreditDerivativesNotices creditDerivativesNotices) {
			this.creditDerivativesNotices = creditDerivativesNotices==null?null:creditDerivativesNotices.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contractualDefinitions")
		public NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions) {
			if (contractualDefinitions!=null) this.contractualDefinitions.add(contractualDefinitions.toBuilder());
			return this;
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions, int _idx) {
			getIndex(this.contractualDefinitions, _idx, () -> contractualDefinitions.toBuilder());
			return this;
		}
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (ContractualDefinitions toAdd : contractualDefinitionss) {
					this.contractualDefinitions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss == null)  {
				this.contractualDefinitions = new ArrayList<>();
			}
			else {
				this.contractualDefinitions = contractualDefinitionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		public NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement) {
			if (contractualTermsSupplement!=null) this.contractualTermsSupplement.add(contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int _idx) {
			getIndex(this.contractualTermsSupplement, _idx, () -> contractualTermsSupplement.toBuilder());
			return this;
		}
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationTermsModel.NovationTermsModelBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null)  {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public NovationTermsModel build() {
			return new NovationTermsModel.NovationTermsModelImpl(this);
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationTermsModel.NovationTermsModelBuilder prune() {
			firstPeriodStartDate = firstPeriodStartDate.stream().filter(b->b!=null).<FirstPeriodStartDate.FirstPeriodStartDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (nonReliance!=null && !nonReliance.prune().hasData()) nonReliance = null;
			if (creditDerivativesNotices!=null && !creditDerivativesNotices.prune().hasData()) creditDerivativesNotices = null;
			contractualDefinitions = contractualDefinitions.stream().filter(b->b!=null).<ContractualDefinitions.ContractualDefinitionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFullFirstCalculationPeriod()!=null) return true;
			if (getFirstPeriodStartDate()!=null && getFirstPeriodStartDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNonReliance()!=null && getNonReliance().hasData()) return true;
			if (getCreditDerivativesNotices()!=null && getCreditDerivativesNotices().hasData()) return true;
			if (getContractualDefinitions()!=null && getContractualDefinitions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationTermsModel.NovationTermsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationTermsModel.NovationTermsModelBuilder o = (NovationTermsModel.NovationTermsModelBuilder) other;
			
			merger.mergeRosetta(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::getOrCreateFirstPeriodStartDate);
			merger.mergeRosetta(getNonReliance(), o.getNonReliance(), this::setNonReliance);
			merger.mergeRosetta(getCreditDerivativesNotices(), o.getCreditDerivativesNotices(), this::setCreditDerivativesNotices);
			merger.mergeRosetta(getContractualDefinitions(), o.getContractualDefinitions(), this::getOrCreateContractualDefinitions);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			
			merger.mergeBasic(getFullFirstCalculationPeriod(), o.getFullFirstCalculationPeriod(), this::setFullFirstCalculationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(fullFirstCalculationPeriod, _that.getFullFirstCalculationPeriod())) return false;
			if (!ListEquals.listEquals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(creditDerivativesNotices, _that.getCreditDerivativesNotices())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fullFirstCalculationPeriod != null ? fullFirstCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (creditDerivativesNotices != null ? creditDerivativesNotices.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationTermsModelBuilder {" +
				"fullFirstCalculationPeriod=" + this.fullFirstCalculationPeriod + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"nonReliance=" + this.nonReliance + ", " +
				"creditDerivativesNotices=" + this.creditDerivativesNotices + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement +
			'}';
		}
	}
}
