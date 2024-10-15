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
import fpml.confirmation.PartyGroupType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PartySequence;
import fpml.confirmation.PartySequence.PartySequenceBuilder;
import fpml.confirmation.PartySequence.PartySequenceBuilderImpl;
import fpml.confirmation.PartySequence.PartySequenceImpl;
import fpml.confirmation.meta.PartySequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PartySequence", builder=PartySequence.PartySequenceBuilderImpl.class, version="${project.version}")
public interface PartySequence extends RosettaModelObject {

	PartySequenceMeta metaData = new PartySequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party Group Type, e.g. JointAndSeveralLiability
	 */
	PartyGroupType getGroupType();
	/**
	 * Reference to a party that is a member of the group of entities that are acting together as a single party in a transaction.
	 */
	List<? extends PartyReference> getPartyReference();

	/*********************** Build Methods  ***********************/
	PartySequence build();
	
	PartySequence.PartySequenceBuilder toBuilder();
	
	static PartySequence.PartySequenceBuilder builder() {
		return new PartySequence.PartySequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartySequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartySequence> getType() {
		return PartySequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("groupType"), processor, PartyGroupType.class, getGroupType());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartySequenceBuilder extends PartySequence, RosettaModelObjectBuilder {
		PartyGroupType.PartyGroupTypeBuilder getOrCreateGroupType();
		PartyGroupType.PartyGroupTypeBuilder getGroupType();
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getPartyReference();
		PartySequence.PartySequenceBuilder setGroupType(PartyGroupType groupType);
		PartySequence.PartySequenceBuilder addPartyReference(PartyReference partyReference0);
		PartySequence.PartySequenceBuilder addPartyReference(PartyReference partyReference1, int _idx);
		PartySequence.PartySequenceBuilder addPartyReference(List<? extends PartyReference> partyReference2);
		PartySequence.PartySequenceBuilder setPartyReference(List<? extends PartyReference> partyReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("groupType"), processor, PartyGroupType.PartyGroupTypeBuilder.class, getGroupType());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
		}
		

		PartySequence.PartySequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PartySequence  ***********************/
	class PartySequenceImpl implements PartySequence {
		private final PartyGroupType groupType;
		private final List<? extends PartyReference> partyReference;
		
		protected PartySequenceImpl(PartySequence.PartySequenceBuilder builder) {
			this.groupType = ofNullable(builder.getGroupType()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("groupType")
		public PartyGroupType getGroupType() {
			return groupType;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public List<? extends PartyReference> getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartySequence build() {
			return this;
		}
		
		@Override
		public PartySequence.PartySequenceBuilder toBuilder() {
			PartySequence.PartySequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartySequence.PartySequenceBuilder builder) {
			ofNullable(getGroupType()).ifPresent(builder::setGroupType);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartySequence _that = getType().cast(o);
		
			if (!Objects.equals(groupType, _that.getGroupType())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (groupType != null ? groupType.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartySequence {" +
				"groupType=" + this.groupType + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PartySequence  ***********************/
	class PartySequenceBuilderImpl implements PartySequence.PartySequenceBuilder {
	
		protected PartyGroupType.PartyGroupTypeBuilder groupType;
		protected List<PartyReference.PartyReferenceBuilder> partyReference = new ArrayList<>();
	
		public PartySequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("groupType")
		public PartyGroupType.PartyGroupTypeBuilder getGroupType() {
			return groupType;
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder getOrCreateGroupType() {
			PartyGroupType.PartyGroupTypeBuilder result;
			if (groupType!=null) {
				result = groupType;
			}
			else {
				result = groupType = PartyGroupType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getPartyReference() {
			return partyReference;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference(int _index) {
		
			if (partyReference==null) {
				this.partyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(partyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newPartyReference = PartyReference.builder();
						return newPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("groupType")
		public PartySequence.PartySequenceBuilder setGroupType(PartyGroupType groupType) {
			this.groupType = groupType==null?null:groupType.toBuilder();
			return this;
		}
		@Override
		public PartySequence.PartySequenceBuilder addPartyReference(PartyReference partyReference) {
			if (partyReference!=null) this.partyReference.add(partyReference.toBuilder());
			return this;
		}
		
		@Override
		public PartySequence.PartySequenceBuilder addPartyReference(PartyReference partyReference, int _idx) {
			getIndex(this.partyReference, _idx, () -> partyReference.toBuilder());
			return this;
		}
		@Override 
		public PartySequence.PartySequenceBuilder addPartyReference(List<? extends PartyReference> partyReferences) {
			if (partyReferences != null) {
				for (PartyReference toAdd : partyReferences) {
					this.partyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyReference")
		public PartySequence.PartySequenceBuilder setPartyReference(List<? extends PartyReference> partyReferences) {
			if (partyReferences == null)  {
				this.partyReference = new ArrayList<>();
			}
			else {
				this.partyReference = partyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PartySequence build() {
			return new PartySequence.PartySequenceImpl(this);
		}
		
		@Override
		public PartySequence.PartySequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartySequence.PartySequenceBuilder prune() {
			if (groupType!=null && !groupType.prune().hasData()) groupType = null;
			partyReference = partyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGroupType()!=null && getGroupType().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartySequence.PartySequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartySequence.PartySequenceBuilder o = (PartySequence.PartySequenceBuilder) other;
			
			merger.mergeRosetta(getGroupType(), o.getGroupType(), this::setGroupType);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::getOrCreatePartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartySequence _that = getType().cast(o);
		
			if (!Objects.equals(groupType, _that.getGroupType())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (groupType != null ? groupType.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartySequenceBuilder {" +
				"groupType=" + this.groupType + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
}
