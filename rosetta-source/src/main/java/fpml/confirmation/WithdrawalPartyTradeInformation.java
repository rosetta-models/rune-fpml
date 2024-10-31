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
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.WithdrawalPartyTradeInformation;
import fpml.confirmation.WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder;
import fpml.confirmation.WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl;
import fpml.confirmation.WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationImpl;
import fpml.confirmation.meta.WithdrawalPartyTradeInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining party-specific additional information that may be recorded against a trade, for withdrawal purposes.
 * @version ${project.version}
 */
@RosettaDataType(value="WithdrawalPartyTradeInformation", builder=WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl.class, version="${project.version}")
public interface WithdrawalPartyTradeInformation extends RosettaModelObject {

	WithdrawalPartyTradeInformationMeta metaData = new WithdrawalPartyTradeInformationMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	/**
	 * This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the &quot;partyReference&quot; in the partyTradeInformation block.
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 * Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	WithdrawalPartyTradeInformation build();
	
	WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder();
	
	static WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder() {
		return new WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WithdrawalPartyTradeInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WithdrawalPartyTradeInformation> getType() {
		return WithdrawalPartyTradeInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalPartyTradeInformationBuilder extends WithdrawalPartyTradeInformation, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int _index);
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty0);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime0);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime1, int _idx);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime2);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder prune();
	}

	/*********************** Immutable Implementation of WithdrawalPartyTradeInformation  ***********************/
	class WithdrawalPartyTradeInformationImpl implements WithdrawalPartyTradeInformation {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected WithdrawalPartyTradeInformationImpl(WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public WithdrawalPartyTradeInformation build() {
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder() {
			WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalPartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalPartyTradeInformation {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of WithdrawalPartyTradeInformation  ***********************/
	class WithdrawalPartyTradeInformationBuilderImpl implements WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> reportingRegime = new ArrayList<>();
	
		public WithdrawalPartyTradeInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int _index) {
		
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder result;
			return getIndex(reportingRegime, _index, () -> {
						ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder newReportingRegime = ReportingRegimeIdentifier.builder();
						return newReportingRegime;
					});
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedParty")
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime) {
			if (reportingRegime!=null) this.reportingRegime.add(reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int _idx) {
			getIndex(this.reportingRegime, _idx, () -> reportingRegime.toBuilder());
			return this;
		}
		@Override 
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes != null) {
				for (ReportingRegimeIdentifier toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes == null)  {
				this.reportingRegime = new ArrayList<>();
			}
			else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public WithdrawalPartyTradeInformation build() {
			return new WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationImpl(this);
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder o = (WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalPartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalPartyTradeInformationBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
