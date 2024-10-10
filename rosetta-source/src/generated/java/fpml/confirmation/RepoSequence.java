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
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CallingPartyEnum;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.RepoSequence;
import fpml.confirmation.RepoSequence.RepoSequenceBuilder;
import fpml.confirmation.RepoSequence.RepoSequenceBuilderImpl;
import fpml.confirmation.RepoSequence.RepoSequenceImpl;
import fpml.confirmation.meta.RepoSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RepoSequence", builder=RepoSequence.RepoSequenceBuilderImpl.class, version="${project.version}")
public interface RepoSequence extends RosettaModelObject {

	RepoSequenceMeta metaData = new RepoSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party to the open repo transaction that has a right to demand for exercise of far leg of the open repo transaction. This element represents an enumerated list that includes InitialBuyer, InitialSeller, Either, AsDefinedInMasterAgreement. In the default case either party can call for closing open repo transaction, unless otherwise specified. If electing parties are not defined in open repo confirmation, when they are defined by default in the Master Agreement, AsDefinedInMasterAgreement value should be used. Exact buyer/seller related parties, including any third parties who can demand exercise of open repo transactions on behalf of the parties to the trade (calculation agent, executing broker, etc.), can be defined in the relatedParty element (tradeHeader/partyTradeInformation).
	 */
	CallingPartyEnum getCallingParty();
	/**
	 * Defines the latest date when the open repo transaction can be exercised (and no later than which it must be exercised) on demand by a party to the trade indicated in the electingParty element (or in the Master Agreement, if the electingParty element has AsDefinedInMasterAgreement value). For instance, in the open repo transaction with callDate agreed as business day one year after the trade date far leg can be settled on any day after the near leg settlement date and before and including the callDate. If the call date is not defined in trade terms and / or not included into trade confirmation this element can be omitted.
	 */
	AdjustableOrRelativeDate getCallDate();
	/**
	 * Notice period for open repo transactions in number of days. This element represents agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise.
	 */
	AdjustableOffset getNoticePeriod();
	/**
	 * Notice period for open repo transactions referenced to a party to the trade, in number of days. This element represents agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise and reference to that party.
	 */
	List<? extends PartyNoticePeriod> getPartyNoticePeriod();

	/*********************** Build Methods  ***********************/
	RepoSequence build();
	
	RepoSequence.RepoSequenceBuilder toBuilder();
	
	static RepoSequence.RepoSequenceBuilder builder() {
		return new RepoSequence.RepoSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepoSequence> getType() {
		return RepoSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.class, getCallDate());
		processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.class, getNoticePeriod());
		processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.class, getPartyNoticePeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoSequenceBuilder extends RepoSequence, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCallDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCallDate();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod();
		AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod();
		PartyNoticePeriod.PartyNoticePeriodBuilder getOrCreatePartyNoticePeriod(int _index);
		List<? extends PartyNoticePeriod.PartyNoticePeriodBuilder> getPartyNoticePeriod();
		RepoSequence.RepoSequenceBuilder setCallingParty(CallingPartyEnum callingParty);
		RepoSequence.RepoSequenceBuilder setCallDate(AdjustableOrRelativeDate callDate);
		RepoSequence.RepoSequenceBuilder setNoticePeriod(AdjustableOffset noticePeriod);
		RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod0);
		RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod1, int _idx);
		RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod2);
		RepoSequence.RepoSequenceBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCallDate());
			processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getNoticePeriod());
			processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.PartyNoticePeriodBuilder.class, getPartyNoticePeriod());
		}
		

		RepoSequence.RepoSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of RepoSequence  ***********************/
	class RepoSequenceImpl implements RepoSequence {
		private final CallingPartyEnum callingParty;
		private final AdjustableOrRelativeDate callDate;
		private final AdjustableOffset noticePeriod;
		private final List<? extends PartyNoticePeriod> partyNoticePeriod;
		
		protected RepoSequenceImpl(RepoSequence.RepoSequenceBuilder builder) {
			this.callingParty = builder.getCallingParty();
			this.callDate = ofNullable(builder.getCallDate()).map(f->f.build()).orElse(null);
			this.noticePeriod = ofNullable(builder.getNoticePeriod()).map(f->f.build()).orElse(null);
			this.partyNoticePeriod = ofNullable(builder.getPartyNoticePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("callDate")
		public AdjustableOrRelativeDate getCallDate() {
			return callDate;
		}
		
		@Override
		@RosettaAttribute("noticePeriod")
		public AdjustableOffset getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		@RosettaAttribute("partyNoticePeriod")
		public List<? extends PartyNoticePeriod> getPartyNoticePeriod() {
			return partyNoticePeriod;
		}
		
		@Override
		public RepoSequence build() {
			return this;
		}
		
		@Override
		public RepoSequence.RepoSequenceBuilder toBuilder() {
			RepoSequence.RepoSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoSequence.RepoSequenceBuilder builder) {
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getCallDate()).ifPresent(builder::setCallDate);
			ofNullable(getNoticePeriod()).ifPresent(builder::setNoticePeriod);
			ofNullable(getPartyNoticePeriod()).ifPresent(builder::setPartyNoticePeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoSequence _that = getType().cast(o);
		
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoSequence {" +
				"callingParty=" + this.callingParty + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of RepoSequence  ***********************/
	class RepoSequenceBuilderImpl implements RepoSequence.RepoSequenceBuilder {
	
		protected CallingPartyEnum callingParty;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder callDate;
		protected AdjustableOffset.AdjustableOffsetBuilder noticePeriod;
		protected List<PartyNoticePeriod.PartyNoticePeriodBuilder> partyNoticePeriod = new ArrayList<>();
	
		public RepoSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("callDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCallDate() {
			return callDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCallDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (callDate!=null) {
				result = callDate;
			}
			else {
				result = callDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noticePeriod")
		public AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod() {
			AdjustableOffset.AdjustableOffsetBuilder result;
			if (noticePeriod!=null) {
				result = noticePeriod;
			}
			else {
				result = noticePeriod = AdjustableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyNoticePeriod")
		public List<? extends PartyNoticePeriod.PartyNoticePeriodBuilder> getPartyNoticePeriod() {
			return partyNoticePeriod;
		}
		
		public PartyNoticePeriod.PartyNoticePeriodBuilder getOrCreatePartyNoticePeriod(int _index) {
		
			if (partyNoticePeriod==null) {
				this.partyNoticePeriod = new ArrayList<>();
			}
			PartyNoticePeriod.PartyNoticePeriodBuilder result;
			return getIndex(partyNoticePeriod, _index, () -> {
						PartyNoticePeriod.PartyNoticePeriodBuilder newPartyNoticePeriod = PartyNoticePeriod.builder();
						return newPartyNoticePeriod;
					});
		}
		
		@Override
		@RosettaAttribute("callingParty")
		public RepoSequence.RepoSequenceBuilder setCallingParty(CallingPartyEnum callingParty) {
			this.callingParty = callingParty==null?null:callingParty;
			return this;
		}
		@Override
		@RosettaAttribute("callDate")
		public RepoSequence.RepoSequenceBuilder setCallDate(AdjustableOrRelativeDate callDate) {
			this.callDate = callDate==null?null:callDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticePeriod")
		public RepoSequence.RepoSequenceBuilder setNoticePeriod(AdjustableOffset noticePeriod) {
			this.noticePeriod = noticePeriod==null?null:noticePeriod.toBuilder();
			return this;
		}
		@Override
		public RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod) {
			if (partyNoticePeriod!=null) this.partyNoticePeriod.add(partyNoticePeriod.toBuilder());
			return this;
		}
		
		@Override
		public RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod, int _idx) {
			getIndex(this.partyNoticePeriod, _idx, () -> partyNoticePeriod.toBuilder());
			return this;
		}
		@Override 
		public RepoSequence.RepoSequenceBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
			if (partyNoticePeriods != null) {
				for (PartyNoticePeriod toAdd : partyNoticePeriods) {
					this.partyNoticePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyNoticePeriod")
		public RepoSequence.RepoSequenceBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
			if (partyNoticePeriods == null)  {
				this.partyNoticePeriod = new ArrayList<>();
			}
			else {
				this.partyNoticePeriod = partyNoticePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public RepoSequence build() {
			return new RepoSequence.RepoSequenceImpl(this);
		}
		
		@Override
		public RepoSequence.RepoSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoSequence.RepoSequenceBuilder prune() {
			if (callDate!=null && !callDate.prune().hasData()) callDate = null;
			if (noticePeriod!=null && !noticePeriod.prune().hasData()) noticePeriod = null;
			partyNoticePeriod = partyNoticePeriod.stream().filter(b->b!=null).<PartyNoticePeriod.PartyNoticePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCallingParty()!=null) return true;
			if (getCallDate()!=null && getCallDate().hasData()) return true;
			if (getNoticePeriod()!=null && getNoticePeriod().hasData()) return true;
			if (getPartyNoticePeriod()!=null && getPartyNoticePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoSequence.RepoSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RepoSequence.RepoSequenceBuilder o = (RepoSequence.RepoSequenceBuilder) other;
			
			merger.mergeRosetta(getCallDate(), o.getCallDate(), this::setCallDate);
			merger.mergeRosetta(getNoticePeriod(), o.getNoticePeriod(), this::setNoticePeriod);
			merger.mergeRosetta(getPartyNoticePeriod(), o.getPartyNoticePeriod(), this::getOrCreatePartyNoticePeriod);
			
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoSequence _that = getType().cast(o);
		
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoSequenceBuilder {" +
				"callingParty=" + this.callingParty + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod +
			'}';
		}
	}
}
