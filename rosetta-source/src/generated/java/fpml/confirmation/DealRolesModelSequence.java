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
import fpml.confirmation.DealRolesModelSequence;
import fpml.confirmation.DealRolesModelSequence.DealRolesModelSequenceBuilder;
import fpml.confirmation.DealRolesModelSequence.DealRolesModelSequenceBuilderImpl;
import fpml.confirmation.DealRolesModelSequence.DealRolesModelSequenceImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.DealRolesModelSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DealRolesModelSequence", builder=DealRolesModelSequence.DealRolesModelSequenceBuilderImpl.class, version="${project.version}")
public interface DealRolesModelSequence extends RosettaModelObject {

	DealRolesModelSequenceMeta metaData = new DealRolesModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party reference to the lead syndication bank of the deal.
	 */
	PartyReference getSyndicationLeadPartyReference();
	/**
	 * Party references to the syndication co-lead banks of the deal.
	 */
	List<? extends PartyReference> getSyndicationCoLeadPartyReference();

	/*********************** Build Methods  ***********************/
	DealRolesModelSequence build();
	
	DealRolesModelSequence.DealRolesModelSequenceBuilder toBuilder();
	
	static DealRolesModelSequence.DealRolesModelSequenceBuilder builder() {
		return new DealRolesModelSequence.DealRolesModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealRolesModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealRolesModelSequence> getType() {
		return DealRolesModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("syndicationLeadPartyReference"), processor, PartyReference.class, getSyndicationLeadPartyReference());
		processRosetta(path.newSubPath("syndicationCoLeadPartyReference"), processor, PartyReference.class, getSyndicationCoLeadPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealRolesModelSequenceBuilder extends DealRolesModelSequence, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateSyndicationLeadPartyReference();
		PartyReference.PartyReferenceBuilder getSyndicationLeadPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSyndicationCoLeadPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getSyndicationCoLeadPartyReference();
		DealRolesModelSequence.DealRolesModelSequenceBuilder setSyndicationLeadPartyReference(PartyReference syndicationLeadPartyReference);
		DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference0);
		DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference1, int _idx);
		DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference2);
		DealRolesModelSequence.DealRolesModelSequenceBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("syndicationLeadPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSyndicationLeadPartyReference());
			processRosetta(path.newSubPath("syndicationCoLeadPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSyndicationCoLeadPartyReference());
		}
		

		DealRolesModelSequence.DealRolesModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DealRolesModelSequence  ***********************/
	class DealRolesModelSequenceImpl implements DealRolesModelSequence {
		private final PartyReference syndicationLeadPartyReference;
		private final List<? extends PartyReference> syndicationCoLeadPartyReference;
		
		protected DealRolesModelSequenceImpl(DealRolesModelSequence.DealRolesModelSequenceBuilder builder) {
			this.syndicationLeadPartyReference = ofNullable(builder.getSyndicationLeadPartyReference()).map(f->f.build()).orElse(null);
			this.syndicationCoLeadPartyReference = ofNullable(builder.getSyndicationCoLeadPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("syndicationLeadPartyReference")
		public PartyReference getSyndicationLeadPartyReference() {
			return syndicationLeadPartyReference;
		}
		
		@Override
		@RosettaAttribute("syndicationCoLeadPartyReference")
		public List<? extends PartyReference> getSyndicationCoLeadPartyReference() {
			return syndicationCoLeadPartyReference;
		}
		
		@Override
		public DealRolesModelSequence build() {
			return this;
		}
		
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder toBuilder() {
			DealRolesModelSequence.DealRolesModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealRolesModelSequence.DealRolesModelSequenceBuilder builder) {
			ofNullable(getSyndicationLeadPartyReference()).ifPresent(builder::setSyndicationLeadPartyReference);
			ofNullable(getSyndicationCoLeadPartyReference()).ifPresent(builder::setSyndicationCoLeadPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRolesModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(syndicationLeadPartyReference, _that.getSyndicationLeadPartyReference())) return false;
			if (!ListEquals.listEquals(syndicationCoLeadPartyReference, _that.getSyndicationCoLeadPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (syndicationLeadPartyReference != null ? syndicationLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationCoLeadPartyReference != null ? syndicationCoLeadPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRolesModelSequence {" +
				"syndicationLeadPartyReference=" + this.syndicationLeadPartyReference + ", " +
				"syndicationCoLeadPartyReference=" + this.syndicationCoLeadPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DealRolesModelSequence  ***********************/
	class DealRolesModelSequenceBuilderImpl implements DealRolesModelSequence.DealRolesModelSequenceBuilder {
	
		protected PartyReference.PartyReferenceBuilder syndicationLeadPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> syndicationCoLeadPartyReference = new ArrayList<>();
	
		public DealRolesModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("syndicationLeadPartyReference")
		public PartyReference.PartyReferenceBuilder getSyndicationLeadPartyReference() {
			return syndicationLeadPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSyndicationLeadPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (syndicationLeadPartyReference!=null) {
				result = syndicationLeadPartyReference;
			}
			else {
				result = syndicationLeadPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("syndicationCoLeadPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getSyndicationCoLeadPartyReference() {
			return syndicationCoLeadPartyReference;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreateSyndicationCoLeadPartyReference(int _index) {
		
			if (syndicationCoLeadPartyReference==null) {
				this.syndicationCoLeadPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(syndicationCoLeadPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newSyndicationCoLeadPartyReference = PartyReference.builder();
						return newSyndicationCoLeadPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("syndicationLeadPartyReference")
		public DealRolesModelSequence.DealRolesModelSequenceBuilder setSyndicationLeadPartyReference(PartyReference syndicationLeadPartyReference) {
			this.syndicationLeadPartyReference = syndicationLeadPartyReference==null?null:syndicationLeadPartyReference.toBuilder();
			return this;
		}
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference) {
			if (syndicationCoLeadPartyReference!=null) this.syndicationCoLeadPartyReference.add(syndicationCoLeadPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference, int _idx) {
			getIndex(this.syndicationCoLeadPartyReference, _idx, () -> syndicationCoLeadPartyReference.toBuilder());
			return this;
		}
		@Override 
		public DealRolesModelSequence.DealRolesModelSequenceBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
			if (syndicationCoLeadPartyReferences != null) {
				for (PartyReference toAdd : syndicationCoLeadPartyReferences) {
					this.syndicationCoLeadPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("syndicationCoLeadPartyReference")
		public DealRolesModelSequence.DealRolesModelSequenceBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
			if (syndicationCoLeadPartyReferences == null)  {
				this.syndicationCoLeadPartyReference = new ArrayList<>();
			}
			else {
				this.syndicationCoLeadPartyReference = syndicationCoLeadPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DealRolesModelSequence build() {
			return new DealRolesModelSequence.DealRolesModelSequenceImpl(this);
		}
		
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder prune() {
			if (syndicationLeadPartyReference!=null && !syndicationLeadPartyReference.prune().hasData()) syndicationLeadPartyReference = null;
			syndicationCoLeadPartyReference = syndicationCoLeadPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSyndicationLeadPartyReference()!=null && getSyndicationLeadPartyReference().hasData()) return true;
			if (getSyndicationCoLeadPartyReference()!=null && getSyndicationCoLeadPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DealRolesModelSequence.DealRolesModelSequenceBuilder o = (DealRolesModelSequence.DealRolesModelSequenceBuilder) other;
			
			merger.mergeRosetta(getSyndicationLeadPartyReference(), o.getSyndicationLeadPartyReference(), this::setSyndicationLeadPartyReference);
			merger.mergeRosetta(getSyndicationCoLeadPartyReference(), o.getSyndicationCoLeadPartyReference(), this::getOrCreateSyndicationCoLeadPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRolesModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(syndicationLeadPartyReference, _that.getSyndicationLeadPartyReference())) return false;
			if (!ListEquals.listEquals(syndicationCoLeadPartyReference, _that.getSyndicationCoLeadPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (syndicationLeadPartyReference != null ? syndicationLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationCoLeadPartyReference != null ? syndicationCoLeadPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRolesModelSequenceBuilder {" +
				"syndicationLeadPartyReference=" + this.syndicationLeadPartyReference + ", " +
				"syndicationCoLeadPartyReference=" + this.syndicationCoLeadPartyReference +
			'}';
		}
	}
}
