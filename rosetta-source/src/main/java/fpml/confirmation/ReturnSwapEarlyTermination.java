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
import fpml.confirmation.PartyReference;
import fpml.confirmation.ReturnSwapEarlyTermination;
import fpml.confirmation.ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder;
import fpml.confirmation.ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilderImpl;
import fpml.confirmation.ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationImpl;
import fpml.confirmation.StartingDate;
import fpml.confirmation.meta.ReturnSwapEarlyTerminationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the date from which each of the party may be allowed to terminate the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapEarlyTermination", builder=ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilderImpl.class, version="${project.version}")
public interface ReturnSwapEarlyTermination extends RosettaModelObject {

	ReturnSwapEarlyTerminationMeta metaData = new ReturnSwapEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a party defined elsewhere in this document which may be allowed to terminate the trade.
	 */
	PartyReference getPartyReference();
	/**
	 * Specifies the date from which the early termination clause can be exercised.
	 */
	StartingDate getStartingDate();

	/*********************** Build Methods  ***********************/
	ReturnSwapEarlyTermination build();
	
	ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder toBuilder();
	
	static ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder builder() {
		return new ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapEarlyTermination> getType() {
		return ReturnSwapEarlyTermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("startingDate"), processor, StartingDate.class, getStartingDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapEarlyTerminationBuilder extends ReturnSwapEarlyTermination, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		StartingDate.StartingDateBuilder getOrCreateStartingDate();
		StartingDate.StartingDateBuilder getStartingDate();
		ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder setPartyReference(PartyReference partyReference);
		ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder setStartingDate(StartingDate startingDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("startingDate"), processor, StartingDate.StartingDateBuilder.class, getStartingDate());
		}
		

		ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapEarlyTermination  ***********************/
	class ReturnSwapEarlyTerminationImpl implements ReturnSwapEarlyTermination {
		private final PartyReference partyReference;
		private final StartingDate startingDate;
		
		protected ReturnSwapEarlyTerminationImpl(ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.startingDate = ofNullable(builder.getStartingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("startingDate")
		public StartingDate getStartingDate() {
			return startingDate;
		}
		
		@Override
		public ReturnSwapEarlyTermination build() {
			return this;
		}
		
		@Override
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder toBuilder() {
			ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getStartingDate()).ifPresent(builder::setStartingDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(startingDate, _that.getStartingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (startingDate != null ? startingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapEarlyTermination {" +
				"partyReference=" + this.partyReference + ", " +
				"startingDate=" + this.startingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnSwapEarlyTermination  ***********************/
	class ReturnSwapEarlyTerminationBuilderImpl implements ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected StartingDate.StartingDateBuilder startingDate;
	
		public ReturnSwapEarlyTerminationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startingDate")
		public StartingDate.StartingDateBuilder getStartingDate() {
			return startingDate;
		}
		
		@Override
		public StartingDate.StartingDateBuilder getOrCreateStartingDate() {
			StartingDate.StartingDateBuilder result;
			if (startingDate!=null) {
				result = startingDate;
			}
			else {
				result = startingDate = StartingDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("startingDate")
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder setStartingDate(StartingDate startingDate) {
			this.startingDate = startingDate==null?null:startingDate.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapEarlyTermination build() {
			return new ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationImpl(this);
		}
		
		@Override
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (startingDate!=null && !startingDate.prune().hasData()) startingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getStartingDate()!=null && getStartingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder o = (ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getStartingDate(), o.getStartingDate(), this::setStartingDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(startingDate, _that.getStartingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (startingDate != null ? startingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapEarlyTerminationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"startingDate=" + this.startingDate +
			'}';
		}
	}
}
