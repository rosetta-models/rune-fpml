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
import fpml.confirmation.PartyTradeIdentifiers;
import fpml.confirmation.PartyTradeIdentifiers.PartyTradeIdentifiersBuilder;
import fpml.confirmation.PartyTradeIdentifiers.PartyTradeIdentifiersBuilderImpl;
import fpml.confirmation.PartyTradeIdentifiers.PartyTradeIdentifiersImpl;
import fpml.confirmation.meta.PartyTradeIdentifiersMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type containing multiple partyTradeIdentifier.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartyTradeIdentifiers", builder=PartyTradeIdentifiers.PartyTradeIdentifiersBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartyTradeIdentifiers extends RosettaModelObject {

	PartyTradeIdentifiersMeta metaData = new PartyTradeIdentifiersMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();

	/*********************** Build Methods  ***********************/
	PartyTradeIdentifiers build();
	
	PartyTradeIdentifiers.PartyTradeIdentifiersBuilder toBuilder();
	
	static PartyTradeIdentifiers.PartyTradeIdentifiersBuilder builder() {
		return new PartyTradeIdentifiers.PartyTradeIdentifiersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeIdentifiers> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyTradeIdentifiers> getType() {
		return PartyTradeIdentifiers.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeIdentifiersBuilder extends PartyTradeIdentifiers, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier0);
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier1, int _idx);
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier2);
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
		}
		

		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeIdentifiers  ***********************/
	class PartyTradeIdentifiersImpl implements PartyTradeIdentifiers {
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		
		protected PartyTradeIdentifiersImpl(PartyTradeIdentifiers.PartyTradeIdentifiersBuilder builder) {
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifiers build() {
			return this;
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder toBuilder() {
			PartyTradeIdentifiers.PartyTradeIdentifiersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeIdentifiers.PartyTradeIdentifiersBuilder builder) {
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeIdentifiers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifiers {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTradeIdentifiers  ***********************/
	class PartyTradeIdentifiersBuilderImpl implements PartyTradeIdentifiers.PartyTradeIdentifiersBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
	
		public PartyTradeIdentifiersBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
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
		@RosettaAttribute("partyTradeIdentifier")
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			if (partyTradeIdentifier!=null) this.partyTradeIdentifier.add(partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int _idx) {
			getIndex(this.partyTradeIdentifier, _idx, () -> partyTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
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
		public PartyTradeIdentifiers build() {
			return new PartyTradeIdentifiers.PartyTradeIdentifiersImpl(this);
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder prune() {
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTradeIdentifiers.PartyTradeIdentifiersBuilder o = (PartyTradeIdentifiers.PartyTradeIdentifiersBuilder) other;
			
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeIdentifiers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifiersBuilder {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier +
			'}';
		}
	}
}
