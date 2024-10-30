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
import fpml.confirmation.AssetValuation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.SensitivitySetDefinition;
import fpml.confirmation.ValuationScenario;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.ValuationSet;
import fpml.confirmation.ValuationSet.ValuationSetBuilder;
import fpml.confirmation.ValuationSet.ValuationSetBuilderImpl;
import fpml.confirmation.ValuationSet.ValuationSetImpl;
import fpml.confirmation.ValuationSetDetail;
import fpml.confirmation.meta.ValuationSetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of valuation inputs and results. This structure can be used for requesting valuations, or for reporting them. In general, the request fills in fewer elements.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ValuationSet", builder=ValuationSet.ValuationSetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ValuationSet extends RosettaModelObject {

	ValuationSetMeta metaData = new ValuationSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the valuation set, used to understand what it means. E.g., &quot;EOD Values and Risks for Party A&quot;.
	 */
	String getName();
	/**
	 * Valuation scenerios used (requested/reported) in this valuation set. E.g., the EOD valuation scenario for a particular value date. Used for the first occurrence of a valuation scenario in a document.
	 */
	List<? extends ValuationScenario> getValuationScenario();
	/**
	 * References to valuation scenarios used (requested/reported) in this valuation set. E..g, a reference to the EOD valuation scenario for a particular value date. Used for subsequence occurrences of a valuation set in an FpML document.
	 */
	List<? extends ValuationScenarioReference> getValuationScenarioReference();
	/**
	 * Reference to the party from whose point of view the assets are valued.
	 */
	PartyReference getBaseParty();
	/**
	 * Charactistics (measure types, units, sides, etc.) of the quotes used (requested/reported) in the valuation set.
	 */
	List<? extends QuotationCharacteristics> getQuotationCharacteristics();
	/**
	 * Definition(s) of sensitivity sets used (requested or reported) in this valuation set.
	 */
	List<? extends SensitivitySetDefinition> getSensitivitySetDefinition();
	/**
	 * Does this valuation set include a market environment?
	 */
	ValuationSetDetail getDetail();
	/**
	 * Valuations reported in this valuation set. These values can be values (NPVs, prices, etc.) or risks (DAR, etc.) and can include sensitivities.
	 */
	List<? extends AssetValuation> getAssetValuation();
	String getId();

	/*********************** Build Methods  ***********************/
	ValuationSet build();
	
	ValuationSet.ValuationSetBuilder toBuilder();
	
	static ValuationSet.ValuationSetBuilder builder() {
		return new ValuationSet.ValuationSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationSet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationSet> getType() {
		return ValuationSet.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationScenario"), processor, ValuationScenario.class, getValuationScenario());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("baseParty"), processor, PartyReference.class, getBaseParty());
		processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.class, getQuotationCharacteristics());
		processRosetta(path.newSubPath("sensitivitySetDefinition"), processor, SensitivitySetDefinition.class, getSensitivitySetDefinition());
		processRosetta(path.newSubPath("detail"), processor, ValuationSetDetail.class, getDetail());
		processRosetta(path.newSubPath("assetValuation"), processor, AssetValuation.class, getAssetValuation());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationSetBuilder extends ValuationSet, RosettaModelObjectBuilder {
		ValuationScenario.ValuationScenarioBuilder getOrCreateValuationScenario(int _index);
		List<? extends ValuationScenario.ValuationScenarioBuilder> getValuationScenario();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference(int _index);
		List<? extends ValuationScenarioReference.ValuationScenarioReferenceBuilder> getValuationScenarioReference();
		PartyReference.PartyReferenceBuilder getOrCreateBaseParty();
		PartyReference.PartyReferenceBuilder getBaseParty();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics(int _index);
		List<? extends QuotationCharacteristics.QuotationCharacteristicsBuilder> getQuotationCharacteristics();
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder getOrCreateSensitivitySetDefinition(int _index);
		List<? extends SensitivitySetDefinition.SensitivitySetDefinitionBuilder> getSensitivitySetDefinition();
		ValuationSetDetail.ValuationSetDetailBuilder getOrCreateDetail();
		ValuationSetDetail.ValuationSetDetailBuilder getDetail();
		AssetValuation.AssetValuationBuilder getOrCreateAssetValuation(int _index);
		List<? extends AssetValuation.AssetValuationBuilder> getAssetValuation();
		ValuationSet.ValuationSetBuilder setName(String name);
		ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario0);
		ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario1, int _idx);
		ValuationSet.ValuationSetBuilder addValuationScenario(List<? extends ValuationScenario> valuationScenario2);
		ValuationSet.ValuationSetBuilder setValuationScenario(List<? extends ValuationScenario> valuationScenario3);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference0);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference1, int _idx);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReference2);
		ValuationSet.ValuationSetBuilder setValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReference3);
		ValuationSet.ValuationSetBuilder setBaseParty(PartyReference baseParty);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics0);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics1, int _idx);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristics2);
		ValuationSet.ValuationSetBuilder setQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristics3);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition0);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition1, int _idx);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinition2);
		ValuationSet.ValuationSetBuilder setSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinition3);
		ValuationSet.ValuationSetBuilder setDetail(ValuationSetDetail detail);
		ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation0);
		ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation1, int _idx);
		ValuationSet.ValuationSetBuilder addAssetValuation(List<? extends AssetValuation> assetValuation2);
		ValuationSet.ValuationSetBuilder setAssetValuation(List<? extends AssetValuation> assetValuation3);
		ValuationSet.ValuationSetBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationScenario"), processor, ValuationScenario.ValuationScenarioBuilder.class, getValuationScenario());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("baseParty"), processor, PartyReference.PartyReferenceBuilder.class, getBaseParty());
			processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getQuotationCharacteristics());
			processRosetta(path.newSubPath("sensitivitySetDefinition"), processor, SensitivitySetDefinition.SensitivitySetDefinitionBuilder.class, getSensitivitySetDefinition());
			processRosetta(path.newSubPath("detail"), processor, ValuationSetDetail.ValuationSetDetailBuilder.class, getDetail());
			processRosetta(path.newSubPath("assetValuation"), processor, AssetValuation.AssetValuationBuilder.class, getAssetValuation());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ValuationSet.ValuationSetBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationSet  ***********************/
	class ValuationSetImpl implements ValuationSet {
		private final String name;
		private final List<? extends ValuationScenario> valuationScenario;
		private final List<? extends ValuationScenarioReference> valuationScenarioReference;
		private final PartyReference baseParty;
		private final List<? extends QuotationCharacteristics> quotationCharacteristics;
		private final List<? extends SensitivitySetDefinition> sensitivitySetDefinition;
		private final ValuationSetDetail detail;
		private final List<? extends AssetValuation> assetValuation;
		private final String id;
		
		protected ValuationSetImpl(ValuationSet.ValuationSetBuilder builder) {
			this.name = builder.getName();
			this.valuationScenario = ofNullable(builder.getValuationScenario()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.baseParty = ofNullable(builder.getBaseParty()).map(f->f.build()).orElse(null);
			this.quotationCharacteristics = ofNullable(builder.getQuotationCharacteristics()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sensitivitySetDefinition = ofNullable(builder.getSensitivitySetDefinition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.detail = ofNullable(builder.getDetail()).map(f->f.build()).orElse(null);
			this.assetValuation = ofNullable(builder.getAssetValuation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenario")
		public List<? extends ValuationScenario> getValuationScenario() {
			return valuationScenario;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public List<? extends ValuationScenarioReference> getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("baseParty")
		public PartyReference getBaseParty() {
			return baseParty;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public List<? extends QuotationCharacteristics> getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		@RosettaAttribute("sensitivitySetDefinition")
		public List<? extends SensitivitySetDefinition> getSensitivitySetDefinition() {
			return sensitivitySetDefinition;
		}
		
		@Override
		@RosettaAttribute("detail")
		public ValuationSetDetail getDetail() {
			return detail;
		}
		
		@Override
		@RosettaAttribute("assetValuation")
		public List<? extends AssetValuation> getAssetValuation() {
			return assetValuation;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ValuationSet build() {
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder toBuilder() {
			ValuationSet.ValuationSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationSet.ValuationSetBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationScenario()).ifPresent(builder::setValuationScenario);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getBaseParty()).ifPresent(builder::setBaseParty);
			ofNullable(getQuotationCharacteristics()).ifPresent(builder::setQuotationCharacteristics);
			ofNullable(getSensitivitySetDefinition()).ifPresent(builder::setSensitivitySetDefinition);
			ofNullable(getDetail()).ifPresent(builder::setDetail);
			ofNullable(getAssetValuation()).ifPresent(builder::setAssetValuation);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(valuationScenario, _that.getValuationScenario())) return false;
			if (!ListEquals.listEquals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(baseParty, _that.getBaseParty())) return false;
			if (!ListEquals.listEquals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			if (!ListEquals.listEquals(sensitivitySetDefinition, _that.getSensitivitySetDefinition())) return false;
			if (!Objects.equals(detail, _that.getDetail())) return false;
			if (!ListEquals.listEquals(assetValuation, _that.getAssetValuation())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenario != null ? valuationScenario.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (baseParty != null ? baseParty.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			_result = 31 * _result + (sensitivitySetDefinition != null ? sensitivitySetDefinition.hashCode() : 0);
			_result = 31 * _result + (detail != null ? detail.hashCode() : 0);
			_result = 31 * _result + (assetValuation != null ? assetValuation.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSet {" +
				"name=" + this.name + ", " +
				"valuationScenario=" + this.valuationScenario + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"baseParty=" + this.baseParty + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics + ", " +
				"sensitivitySetDefinition=" + this.sensitivitySetDefinition + ", " +
				"detail=" + this.detail + ", " +
				"assetValuation=" + this.assetValuation + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationSet  ***********************/
	class ValuationSetBuilderImpl implements ValuationSet.ValuationSetBuilder {
	
		protected String name;
		protected List<ValuationScenario.ValuationScenarioBuilder> valuationScenario = new ArrayList<>();
		protected List<ValuationScenarioReference.ValuationScenarioReferenceBuilder> valuationScenarioReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder baseParty;
		protected List<QuotationCharacteristics.QuotationCharacteristicsBuilder> quotationCharacteristics = new ArrayList<>();
		protected List<SensitivitySetDefinition.SensitivitySetDefinitionBuilder> sensitivitySetDefinition = new ArrayList<>();
		protected ValuationSetDetail.ValuationSetDetailBuilder detail;
		protected List<AssetValuation.AssetValuationBuilder> assetValuation = new ArrayList<>();
		protected String id;
	
		public ValuationSetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenario")
		public List<? extends ValuationScenario.ValuationScenarioBuilder> getValuationScenario() {
			return valuationScenario;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder getOrCreateValuationScenario(int _index) {
		
			if (valuationScenario==null) {
				this.valuationScenario = new ArrayList<>();
			}
			ValuationScenario.ValuationScenarioBuilder result;
			return getIndex(valuationScenario, _index, () -> {
						ValuationScenario.ValuationScenarioBuilder newValuationScenario = ValuationScenario.builder();
						return newValuationScenario;
					});
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public List<? extends ValuationScenarioReference.ValuationScenarioReferenceBuilder> getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference(int _index) {
		
			if (valuationScenarioReference==null) {
				this.valuationScenarioReference = new ArrayList<>();
			}
			ValuationScenarioReference.ValuationScenarioReferenceBuilder result;
			return getIndex(valuationScenarioReference, _index, () -> {
						ValuationScenarioReference.ValuationScenarioReferenceBuilder newValuationScenarioReference = ValuationScenarioReference.builder();
						return newValuationScenarioReference;
					});
		}
		
		@Override
		@RosettaAttribute("baseParty")
		public PartyReference.PartyReferenceBuilder getBaseParty() {
			return baseParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBaseParty() {
			PartyReference.PartyReferenceBuilder result;
			if (baseParty!=null) {
				result = baseParty;
			}
			else {
				result = baseParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public List<? extends QuotationCharacteristics.QuotationCharacteristicsBuilder> getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics(int _index) {
		
			if (quotationCharacteristics==null) {
				this.quotationCharacteristics = new ArrayList<>();
			}
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			return getIndex(quotationCharacteristics, _index, () -> {
						QuotationCharacteristics.QuotationCharacteristicsBuilder newQuotationCharacteristics = QuotationCharacteristics.builder();
						return newQuotationCharacteristics;
					});
		}
		
		@Override
		@RosettaAttribute("sensitivitySetDefinition")
		public List<? extends SensitivitySetDefinition.SensitivitySetDefinitionBuilder> getSensitivitySetDefinition() {
			return sensitivitySetDefinition;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder getOrCreateSensitivitySetDefinition(int _index) {
		
			if (sensitivitySetDefinition==null) {
				this.sensitivitySetDefinition = new ArrayList<>();
			}
			SensitivitySetDefinition.SensitivitySetDefinitionBuilder result;
			return getIndex(sensitivitySetDefinition, _index, () -> {
						SensitivitySetDefinition.SensitivitySetDefinitionBuilder newSensitivitySetDefinition = SensitivitySetDefinition.builder();
						return newSensitivitySetDefinition;
					});
		}
		
		@Override
		@RosettaAttribute("detail")
		public ValuationSetDetail.ValuationSetDetailBuilder getDetail() {
			return detail;
		}
		
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder getOrCreateDetail() {
			ValuationSetDetail.ValuationSetDetailBuilder result;
			if (detail!=null) {
				result = detail;
			}
			else {
				result = detail = ValuationSetDetail.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetValuation")
		public List<? extends AssetValuation.AssetValuationBuilder> getAssetValuation() {
			return assetValuation;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder getOrCreateAssetValuation(int _index) {
		
			if (assetValuation==null) {
				this.assetValuation = new ArrayList<>();
			}
			AssetValuation.AssetValuationBuilder result;
			return getIndex(assetValuation, _index, () -> {
						AssetValuation.AssetValuationBuilder newAssetValuation = AssetValuation.builder();
						return newAssetValuation;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public ValuationSet.ValuationSetBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenario")
		public ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario) {
			if (valuationScenario!=null) this.valuationScenario.add(valuationScenario.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario, int _idx) {
			getIndex(this.valuationScenario, _idx, () -> valuationScenario.toBuilder());
			return this;
		}
		@Override 
		public ValuationSet.ValuationSetBuilder addValuationScenario(List<? extends ValuationScenario> valuationScenarios) {
			if (valuationScenarios != null) {
				for (ValuationScenario toAdd : valuationScenarios) {
					this.valuationScenario.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationSet.ValuationSetBuilder setValuationScenario(List<? extends ValuationScenario> valuationScenarios) {
			if (valuationScenarios == null)  {
				this.valuationScenario = new ArrayList<>();
			}
			else {
				this.valuationScenario = valuationScenarios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			if (valuationScenarioReference!=null) this.valuationScenarioReference.add(valuationScenarioReference.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference, int _idx) {
			getIndex(this.valuationScenarioReference, _idx, () -> valuationScenarioReference.toBuilder());
			return this;
		}
		@Override 
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReferences) {
			if (valuationScenarioReferences != null) {
				for (ValuationScenarioReference toAdd : valuationScenarioReferences) {
					this.valuationScenarioReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationSet.ValuationSetBuilder setValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReferences) {
			if (valuationScenarioReferences == null)  {
				this.valuationScenarioReference = new ArrayList<>();
			}
			else {
				this.valuationScenarioReference = valuationScenarioReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("baseParty")
		public ValuationSet.ValuationSetBuilder setBaseParty(PartyReference baseParty) {
			this.baseParty = baseParty==null?null:baseParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics) {
			if (quotationCharacteristics!=null) this.quotationCharacteristics.add(quotationCharacteristics.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics, int _idx) {
			getIndex(this.quotationCharacteristics, _idx, () -> quotationCharacteristics.toBuilder());
			return this;
		}
		@Override 
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristicss) {
			if (quotationCharacteristicss != null) {
				for (QuotationCharacteristics toAdd : quotationCharacteristicss) {
					this.quotationCharacteristics.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationSet.ValuationSetBuilder setQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristicss) {
			if (quotationCharacteristicss == null)  {
				this.quotationCharacteristics = new ArrayList<>();
			}
			else {
				this.quotationCharacteristics = quotationCharacteristicss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("sensitivitySetDefinition")
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition) {
			if (sensitivitySetDefinition!=null) this.sensitivitySetDefinition.add(sensitivitySetDefinition.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition, int _idx) {
			getIndex(this.sensitivitySetDefinition, _idx, () -> sensitivitySetDefinition.toBuilder());
			return this;
		}
		@Override 
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinitions) {
			if (sensitivitySetDefinitions != null) {
				for (SensitivitySetDefinition toAdd : sensitivitySetDefinitions) {
					this.sensitivitySetDefinition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationSet.ValuationSetBuilder setSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinitions) {
			if (sensitivitySetDefinitions == null)  {
				this.sensitivitySetDefinition = new ArrayList<>();
			}
			else {
				this.sensitivitySetDefinition = sensitivitySetDefinitions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("detail")
		public ValuationSet.ValuationSetBuilder setDetail(ValuationSetDetail detail) {
			this.detail = detail==null?null:detail.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetValuation")
		public ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation) {
			if (assetValuation!=null) this.assetValuation.add(assetValuation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation, int _idx) {
			getIndex(this.assetValuation, _idx, () -> assetValuation.toBuilder());
			return this;
		}
		@Override 
		public ValuationSet.ValuationSetBuilder addAssetValuation(List<? extends AssetValuation> assetValuations) {
			if (assetValuations != null) {
				for (AssetValuation toAdd : assetValuations) {
					this.assetValuation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationSet.ValuationSetBuilder setAssetValuation(List<? extends AssetValuation> assetValuations) {
			if (assetValuations == null)  {
				this.assetValuation = new ArrayList<>();
			}
			else {
				this.assetValuation = assetValuations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public ValuationSet.ValuationSetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ValuationSet build() {
			return new ValuationSet.ValuationSetImpl(this);
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSet.ValuationSetBuilder prune() {
			valuationScenario = valuationScenario.stream().filter(b->b!=null).<ValuationScenario.ValuationScenarioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationScenarioReference = valuationScenarioReference.stream().filter(b->b!=null).<ValuationScenarioReference.ValuationScenarioReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (baseParty!=null && !baseParty.prune().hasData()) baseParty = null;
			quotationCharacteristics = quotationCharacteristics.stream().filter(b->b!=null).<QuotationCharacteristics.QuotationCharacteristicsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			sensitivitySetDefinition = sensitivitySetDefinition.stream().filter(b->b!=null).<SensitivitySetDefinition.SensitivitySetDefinitionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (detail!=null && !detail.prune().hasData()) detail = null;
			assetValuation = assetValuation.stream().filter(b->b!=null).<AssetValuation.AssetValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getValuationScenario()!=null && getValuationScenario().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBaseParty()!=null && getBaseParty().hasData()) return true;
			if (getQuotationCharacteristics()!=null && getQuotationCharacteristics().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSensitivitySetDefinition()!=null && getSensitivitySetDefinition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDetail()!=null && getDetail().hasData()) return true;
			if (getAssetValuation()!=null && getAssetValuation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSet.ValuationSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationSet.ValuationSetBuilder o = (ValuationSet.ValuationSetBuilder) other;
			
			merger.mergeRosetta(getValuationScenario(), o.getValuationScenario(), this::getOrCreateValuationScenario);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::getOrCreateValuationScenarioReference);
			merger.mergeRosetta(getBaseParty(), o.getBaseParty(), this::setBaseParty);
			merger.mergeRosetta(getQuotationCharacteristics(), o.getQuotationCharacteristics(), this::getOrCreateQuotationCharacteristics);
			merger.mergeRosetta(getSensitivitySetDefinition(), o.getSensitivitySetDefinition(), this::getOrCreateSensitivitySetDefinition);
			merger.mergeRosetta(getDetail(), o.getDetail(), this::setDetail);
			merger.mergeRosetta(getAssetValuation(), o.getAssetValuation(), this::getOrCreateAssetValuation);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(valuationScenario, _that.getValuationScenario())) return false;
			if (!ListEquals.listEquals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(baseParty, _that.getBaseParty())) return false;
			if (!ListEquals.listEquals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			if (!ListEquals.listEquals(sensitivitySetDefinition, _that.getSensitivitySetDefinition())) return false;
			if (!Objects.equals(detail, _that.getDetail())) return false;
			if (!ListEquals.listEquals(assetValuation, _that.getAssetValuation())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenario != null ? valuationScenario.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (baseParty != null ? baseParty.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			_result = 31 * _result + (sensitivitySetDefinition != null ? sensitivitySetDefinition.hashCode() : 0);
			_result = 31 * _result + (detail != null ? detail.hashCode() : 0);
			_result = 31 * _result + (assetValuation != null ? assetValuation.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSetBuilder {" +
				"name=" + this.name + ", " +
				"valuationScenario=" + this.valuationScenario + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"baseParty=" + this.baseParty + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics + ", " +
				"sensitivitySetDefinition=" + this.sensitivitySetDefinition + ", " +
				"detail=" + this.detail + ", " +
				"assetValuation=" + this.assetValuation + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
