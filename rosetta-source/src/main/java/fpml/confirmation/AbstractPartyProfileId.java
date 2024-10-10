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
import fpml.confirmation.AbstractPartyProfileId;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdBuilder;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdImpl;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.meta.AbstractPartyProfileIdMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type that identifies a party profile.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractPartyProfileId", builder=AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl.class, version="${project.version}")
public interface AbstractPartyProfileId extends RosettaModelObject {

	AbstractPartyProfileIdMeta metaData = new AbstractPartyProfileIdMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyProfileIdentifier> getPartyProfileIdentifier();

	/*********************** Build Methods  ***********************/
	AbstractPartyProfileId build();
	
	AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder();
	
	static AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder() {
		return new AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractPartyProfileId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractPartyProfileId> getType() {
		return AbstractPartyProfileId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractPartyProfileIdBuilder extends AbstractPartyProfileId, RosettaModelObjectBuilder {
		PartyProfileIdentifier.PartyProfileIdentifierBuilder getOrCreatePartyProfileIdentifier(int _index);
		List<? extends PartyProfileIdentifier.PartyProfileIdentifierBuilder> getPartyProfileIdentifier();
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier0);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier1, int _idx);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier2);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
		}
		

		AbstractPartyProfileId.AbstractPartyProfileIdBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractPartyProfileId  ***********************/
	class AbstractPartyProfileIdImpl implements AbstractPartyProfileId {
		private final List<? extends PartyProfileIdentifier> partyProfileIdentifier;
		
		protected AbstractPartyProfileIdImpl(AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder) {
			this.partyProfileIdentifier = ofNullable(builder.getPartyProfileIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfileIdentifier")
		public List<? extends PartyProfileIdentifier> getPartyProfileIdentifier() {
			return partyProfileIdentifier;
		}
		
		@Override
		public AbstractPartyProfileId build() {
			return this;
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder() {
			AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder) {
			ofNullable(getPartyProfileIdentifier()).ifPresent(builder::setPartyProfileIdentifier);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractPartyProfileId _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileIdentifier, _that.getPartyProfileIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyProfileIdentifier != null ? partyProfileIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileId {" +
				"partyProfileIdentifier=" + this.partyProfileIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractPartyProfileId  ***********************/
	class AbstractPartyProfileIdBuilderImpl implements AbstractPartyProfileId.AbstractPartyProfileIdBuilder {
	
		protected List<PartyProfileIdentifier.PartyProfileIdentifierBuilder> partyProfileIdentifier = new ArrayList<>();
	
		public AbstractPartyProfileIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyProfileIdentifier")
		public List<? extends PartyProfileIdentifier.PartyProfileIdentifierBuilder> getPartyProfileIdentifier() {
			return partyProfileIdentifier;
		}
		
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder getOrCreatePartyProfileIdentifier(int _index) {
		
			if (partyProfileIdentifier==null) {
				this.partyProfileIdentifier = new ArrayList<>();
			}
			PartyProfileIdentifier.PartyProfileIdentifierBuilder result;
			return getIndex(partyProfileIdentifier, _index, () -> {
						PartyProfileIdentifier.PartyProfileIdentifierBuilder newPartyProfileIdentifier = PartyProfileIdentifier.builder();
						return newPartyProfileIdentifier;
					});
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier) {
			if (partyProfileIdentifier!=null) this.partyProfileIdentifier.add(partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int _idx) {
			getIndex(this.partyProfileIdentifier, _idx, () -> partyProfileIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers != null) {
				for (PartyProfileIdentifier toAdd : partyProfileIdentifiers) {
					this.partyProfileIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyProfileIdentifier")
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers == null)  {
				this.partyProfileIdentifier = new ArrayList<>();
			}
			else {
				this.partyProfileIdentifier = partyProfileIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractPartyProfileId build() {
			return new AbstractPartyProfileId.AbstractPartyProfileIdImpl(this);
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder prune() {
			partyProfileIdentifier = partyProfileIdentifier.stream().filter(b->b!=null).<PartyProfileIdentifier.PartyProfileIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyProfileIdentifier()!=null && getPartyProfileIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractPartyProfileId.AbstractPartyProfileIdBuilder o = (AbstractPartyProfileId.AbstractPartyProfileIdBuilder) other;
			
			merger.mergeRosetta(getPartyProfileIdentifier(), o.getPartyProfileIdentifier(), this::getOrCreatePartyProfileIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractPartyProfileId _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileIdentifier, _that.getPartyProfileIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyProfileIdentifier != null ? partyProfileIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileIdBuilder {" +
				"partyProfileIdentifier=" + this.partyProfileIdentifier +
			'}';
		}
	}
}
