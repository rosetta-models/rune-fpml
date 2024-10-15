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
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.WithdrawalPartyTradeInformation;
import fpml.confirmation.WithdrawalSequence;
import fpml.confirmation.WithdrawalSequence.WithdrawalSequenceBuilder;
import fpml.confirmation.WithdrawalSequence.WithdrawalSequenceBuilderImpl;
import fpml.confirmation.WithdrawalSequence.WithdrawalSequenceImpl;
import fpml.confirmation.meta.WithdrawalSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="WithdrawalSequence", builder=WithdrawalSequence.WithdrawalSequenceBuilderImpl.class, version="${project.version}")
public interface WithdrawalSequence extends RosettaModelObject {

	WithdrawalSequenceMeta metaData = new WithdrawalSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifiers of the trade that is being withdrawn.
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 * Holds party-specific information about the trade that is being withdrawn from.
	 */
	List<? extends WithdrawalPartyTradeInformation> getPartyTradeInformation();

	/*********************** Build Methods  ***********************/
	WithdrawalSequence build();
	
	WithdrawalSequence.WithdrawalSequenceBuilder toBuilder();
	
	static WithdrawalSequence.WithdrawalSequenceBuilder builder() {
		return new WithdrawalSequence.WithdrawalSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WithdrawalSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WithdrawalSequence> getType() {
		return WithdrawalSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, WithdrawalPartyTradeInformation.class, getPartyTradeInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalSequenceBuilder extends WithdrawalSequence, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder getOrCreatePartyTradeInformation(int _index);
		List<? extends WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> getPartyTradeInformation();
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier0);
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier1, int _idx);
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier2);
		WithdrawalSequence.WithdrawalSequenceBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier3);
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation0);
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation1, int _idx);
		WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformation2);
		WithdrawalSequence.WithdrawalSequenceBuilder setPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformation3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder.class, getPartyTradeInformation());
		}
		

		WithdrawalSequence.WithdrawalSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of WithdrawalSequence  ***********************/
	class WithdrawalSequenceImpl implements WithdrawalSequence {
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends WithdrawalPartyTradeInformation> partyTradeInformation;
		
		protected WithdrawalSequenceImpl(WithdrawalSequence.WithdrawalSequenceBuilder builder) {
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		public List<? extends WithdrawalPartyTradeInformation> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		public WithdrawalSequence build() {
			return this;
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder toBuilder() {
			WithdrawalSequence.WithdrawalSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WithdrawalSequence.WithdrawalSequenceBuilder builder) {
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalSequence {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of WithdrawalSequence  ***********************/
	class WithdrawalSequenceBuilderImpl implements WithdrawalSequence.WithdrawalSequenceBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
	
		public WithdrawalSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index) {
		
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(partyTradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		public List<? extends WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder getOrCreatePartyTradeInformation(int _index) {
		
			if (partyTradeInformation==null) {
				this.partyTradeInformation = new ArrayList<>();
			}
			WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder result;
			return getIndex(partyTradeInformation, _index, () -> {
						WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder newPartyTradeInformation = WithdrawalPartyTradeInformation.builder();
						return newPartyTradeInformation;
					});
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			if (partyTradeIdentifier!=null) this.partyTradeIdentifier.add(partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int _idx) {
			getIndex(this.partyTradeIdentifier, _idx, () -> partyTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeIdentifier")
		public WithdrawalSequence.WithdrawalSequenceBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null)  {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation) {
			if (partyTradeInformation!=null) this.partyTradeInformation.add(partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation, int _idx) {
			getIndex(this.partyTradeInformation, _idx, () -> partyTradeInformation.toBuilder());
			return this;
		}
		@Override 
		public WithdrawalSequence.WithdrawalSequenceBuilder addPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (WithdrawalPartyTradeInformation toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeInformation")
		public WithdrawalSequence.WithdrawalSequenceBuilder setPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations == null)  {
				this.partyTradeInformation = new ArrayList<>();
			}
			else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public WithdrawalSequence build() {
			return new WithdrawalSequence.WithdrawalSequenceImpl(this);
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder prune() {
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WithdrawalSequence.WithdrawalSequenceBuilder o = (WithdrawalSequence.WithdrawalSequenceBuilder) other;
			
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalSequenceBuilder {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation +
			'}';
		}
	}
}
