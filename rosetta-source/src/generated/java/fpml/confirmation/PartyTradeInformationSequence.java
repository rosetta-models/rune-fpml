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
import fpml.confirmation.ClearingExceptionReason;
import fpml.confirmation.PartyTradeInformationSequence;
import fpml.confirmation.PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder;
import fpml.confirmation.PartyTradeInformationSequence.PartyTradeInformationSequenceBuilderImpl;
import fpml.confirmation.PartyTradeInformationSequence.PartyTradeInformationSequenceImpl;
import fpml.confirmation.meta.PartyTradeInformationSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PartyTradeInformationSequence", builder=PartyTradeInformationSequence.PartyTradeInformationSequenceBuilderImpl.class, version="${project.version}")
public interface PartyTradeInformationSequence extends RosettaModelObject {

	PartyTradeInformationSequenceMeta metaData = new PartyTradeInformationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. wehter there is an exemption from clearing. For historical reasons this is called &quot;end-user exception&quot;, but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 */
	Boolean getEndUserException();
	/**
	 * Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade.
	 */
	ClearingExceptionReason getEndUserExceptionReason();

	/*********************** Build Methods  ***********************/
	PartyTradeInformationSequence build();
	
	PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder toBuilder();
	
	static PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder builder() {
		return new PartyTradeInformationSequence.PartyTradeInformationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeInformationSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyTradeInformationSequence> getType() {
		return PartyTradeInformationSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
		processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.class, getEndUserExceptionReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeInformationSequenceBuilder extends PartyTradeInformationSequence, RosettaModelObjectBuilder {
		ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason();
		ClearingExceptionReason.ClearingExceptionReasonBuilder getEndUserExceptionReason();
		PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder setEndUserException(Boolean endUserException);
		PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder setEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
			processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.ClearingExceptionReasonBuilder.class, getEndUserExceptionReason());
		}
		

		PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeInformationSequence  ***********************/
	class PartyTradeInformationSequenceImpl implements PartyTradeInformationSequence {
		private final Boolean endUserException;
		private final ClearingExceptionReason endUserExceptionReason;
		
		protected PartyTradeInformationSequenceImpl(PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder builder) {
			this.endUserException = builder.getEndUserException();
			this.endUserExceptionReason = ofNullable(builder.getEndUserExceptionReason()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		public ClearingExceptionReason getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		public PartyTradeInformationSequence build() {
			return this;
		}
		
		@Override
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder toBuilder() {
			PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder builder) {
			ofNullable(getEndUserException()).ifPresent(builder::setEndUserException);
			ofNullable(getEndUserExceptionReason()).ifPresent(builder::setEndUserExceptionReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformationSequence _that = getType().cast(o);
		
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!Objects.equals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationSequence {" +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTradeInformationSequence  ***********************/
	class PartyTradeInformationSequenceBuilderImpl implements PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder {
	
		protected Boolean endUserException;
		protected ClearingExceptionReason.ClearingExceptionReasonBuilder endUserExceptionReason;
	
		public PartyTradeInformationSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		public ClearingExceptionReason.ClearingExceptionReasonBuilder getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason() {
			ClearingExceptionReason.ClearingExceptionReasonBuilder result;
			if (endUserExceptionReason!=null) {
				result = endUserExceptionReason;
			}
			else {
				result = endUserExceptionReason = ClearingExceptionReason.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder setEndUserException(Boolean endUserException) {
			this.endUserException = endUserException==null?null:endUserException;
			return this;
		}
		@Override
		@RosettaAttribute("endUserExceptionReason")
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder setEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason) {
			this.endUserExceptionReason = endUserExceptionReason==null?null:endUserExceptionReason.toBuilder();
			return this;
		}
		
		@Override
		public PartyTradeInformationSequence build() {
			return new PartyTradeInformationSequence.PartyTradeInformationSequenceImpl(this);
		}
		
		@Override
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder prune() {
			if (endUserExceptionReason!=null && !endUserExceptionReason.prune().hasData()) endUserExceptionReason = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEndUserException()!=null) return true;
			if (getEndUserExceptionReason()!=null && getEndUserExceptionReason().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder o = (PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder) other;
			
			merger.mergeRosetta(getEndUserExceptionReason(), o.getEndUserExceptionReason(), this::setEndUserExceptionReason);
			
			merger.mergeBasic(getEndUserException(), o.getEndUserException(), this::setEndUserException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformationSequence _that = getType().cast(o);
		
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!Objects.equals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationSequenceBuilder {" +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason +
			'}';
		}
	}
}
