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
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.LoanNotificationExceptionSequence;
import fpml.confirmation.LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder;
import fpml.confirmation.LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilderImpl;
import fpml.confirmation.LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceImpl;
import fpml.confirmation.Party;
import fpml.confirmation.meta.LoanNotificationExceptionSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanNotificationExceptionSequence", builder=LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanNotificationExceptionSequence extends RosettaModelObject {

	LoanNotificationExceptionSequenceMeta metaData = new LoanNotificationExceptionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	LoanIdentifiersModel getLoanIdentifiersModel();
	Party getParty();

	/*********************** Build Methods  ***********************/
	LoanNotificationExceptionSequence build();
	
	LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder toBuilder();
	
	static LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder builder() {
		return new LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationExceptionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanNotificationExceptionSequence> getType() {
		return LoanNotificationExceptionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.class, getLoanIdentifiersModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationExceptionSequenceBuilder extends LoanNotificationExceptionSequence, RosettaModelObjectBuilder {
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getOrCreateLoanIdentifiersModel();
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getLoanIdentifiersModel();
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel);
		LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder setParty(Party party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.LoanIdentifiersModelBuilder.class, getLoanIdentifiersModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationExceptionSequence  ***********************/
	class LoanNotificationExceptionSequenceImpl implements LoanNotificationExceptionSequence {
		private final LoanIdentifiersModel loanIdentifiersModel;
		private final Party party;
		
		protected LoanNotificationExceptionSequenceImpl(LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder builder) {
			this.loanIdentifiersModel = ofNullable(builder.getLoanIdentifiersModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanIdentifiersModel getLoanIdentifiersModel() {
			return loanIdentifiersModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		public LoanNotificationExceptionSequence build() {
			return this;
		}
		
		@Override
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder toBuilder() {
			LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder builder) {
			ofNullable(getLoanIdentifiersModel()).ifPresent(builder::setLoanIdentifiersModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanNotificationExceptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationExceptionSequence {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel + ", " +
				"party=" + this.party +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanNotificationExceptionSequence  ***********************/
	class LoanNotificationExceptionSequenceBuilderImpl implements LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder {
	
		protected LoanIdentifiersModel.LoanIdentifiersModelBuilder loanIdentifiersModel;
		protected Party.PartyBuilder party;
	
		public LoanNotificationExceptionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder getLoanIdentifiersModel() {
			return loanIdentifiersModel;
		}
		
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder getOrCreateLoanIdentifiersModel() {
			LoanIdentifiersModel.LoanIdentifiersModelBuilder result;
			if (loanIdentifiersModel!=null) {
				result = loanIdentifiersModel;
			}
			else {
				result = loanIdentifiersModel = LoanIdentifiersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel) {
			this.loanIdentifiersModel = loanIdentifiersModel==null?null:loanIdentifiersModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationExceptionSequence build() {
			return new LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceImpl(this);
		}
		
		@Override
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder prune() {
			if (loanIdentifiersModel!=null && !loanIdentifiersModel.prune().hasData()) loanIdentifiersModel = null;
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanIdentifiersModel()!=null && getLoanIdentifiersModel().hasData()) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder o = (LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder) other;
			
			merger.mergeRosetta(getLoanIdentifiersModel(), o.getLoanIdentifiersModel(), this::setLoanIdentifiersModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanNotificationExceptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationExceptionSequenceBuilder {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
