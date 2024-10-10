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
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilder;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilderImpl;
import fpml.confirmation.TradeIdentifier.TradeIdentifierImpl;
import fpml.confirmation.TradeIdentifierExtended;
import fpml.confirmation.TradeIdentifierExtended.TradeIdentifierExtendedBuilder;
import fpml.confirmation.TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl;
import fpml.confirmation.TradeIdentifierExtended.TradeIdentifierExtendedImpl;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.meta.TradeIdentifierExtendedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a trade identifier with a reference to the party that this trade is associated with.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeIdentifierExtended", builder=TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl.class, version="${project.version}")
public interface TradeIdentifierExtended extends TradeIdentifier {

	TradeIdentifierExtendedMeta metaData = new TradeIdentifierExtendedMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getAssociatedPartyReference();

	/*********************** Build Methods  ***********************/
	TradeIdentifierExtended build();
	
	TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder();
	
	static TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder() {
		return new TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifierExtended> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeIdentifierExtended> getType() {
		return TradeIdentifierExtended.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.class, getIssuerTradeIdModel());
		processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.class, getTradeIdentifierSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("associatedPartyReference"), processor, PartyReference.class, getAssociatedPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierExtendedBuilder extends TradeIdentifierExtended, TradeIdentifier.TradeIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAssociatedPartyReference();
		PartyReference.PartyReferenceBuilder getAssociatedPartyReference();
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel);
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence);
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setId(String id);
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAssociatedPartyReference(PartyReference associatedPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.IssuerTradeIdModelBuilder.class, getIssuerTradeIdModel());
			processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.TradeIdentifierSequenceBuilder.class, getTradeIdentifierSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("associatedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAssociatedPartyReference());
		}
		

		TradeIdentifierExtended.TradeIdentifierExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifierExtended  ***********************/
	class TradeIdentifierExtendedImpl extends TradeIdentifier.TradeIdentifierImpl implements TradeIdentifierExtended {
		private final PartyReference associatedPartyReference;
		
		protected TradeIdentifierExtendedImpl(TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder) {
			super(builder);
			this.associatedPartyReference = ofNullable(builder.getAssociatedPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("associatedPartyReference")
		public PartyReference getAssociatedPartyReference() {
			return associatedPartyReference;
		}
		
		@Override
		public TradeIdentifierExtended build() {
			return this;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder() {
			TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAssociatedPartyReference()).ifPresent(builder::setAssociatedPartyReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeIdentifierExtended _that = getType().cast(o);
		
			if (!Objects.equals(associatedPartyReference, _that.getAssociatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (associatedPartyReference != null ? associatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierExtended {" +
				"associatedPartyReference=" + this.associatedPartyReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeIdentifierExtended  ***********************/
	class TradeIdentifierExtendedBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl  implements TradeIdentifierExtended.TradeIdentifierExtendedBuilder {
	
		protected PartyReference.PartyReferenceBuilder associatedPartyReference;
	
		public TradeIdentifierExtendedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("associatedPartyReference")
		public PartyReference.PartyReferenceBuilder getAssociatedPartyReference() {
			return associatedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAssociatedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (associatedPartyReference!=null) {
				result = associatedPartyReference;
			}
			else {
				result = associatedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel) {
			this.issuerTradeIdModel = issuerTradeIdModel==null?null:issuerTradeIdModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence) {
			this.tradeIdentifierSequence = tradeIdentifierSequence==null?null:tradeIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("associatedPartyReference")
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAssociatedPartyReference(PartyReference associatedPartyReference) {
			this.associatedPartyReference = associatedPartyReference==null?null:associatedPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public TradeIdentifierExtended build() {
			return new TradeIdentifierExtended.TradeIdentifierExtendedImpl(this);
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder prune() {
			super.prune();
			if (associatedPartyReference!=null && !associatedPartyReference.prune().hasData()) associatedPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAssociatedPartyReference()!=null && getAssociatedPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeIdentifierExtended.TradeIdentifierExtendedBuilder o = (TradeIdentifierExtended.TradeIdentifierExtendedBuilder) other;
			
			merger.mergeRosetta(getAssociatedPartyReference(), o.getAssociatedPartyReference(), this::setAssociatedPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeIdentifierExtended _that = getType().cast(o);
		
			if (!Objects.equals(associatedPartyReference, _that.getAssociatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (associatedPartyReference != null ? associatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierExtendedBuilder {" +
				"associatedPartyReference=" + this.associatedPartyReference +
			'}' + " " + super.toString();
		}
	}
}
