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
import fpml.confirmation.AbstractApplicablePartyProfileObjects;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.meta.AbstractApplicablePartyProfileObjectsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type that combines objects applicable to the description of a party profile (e.g. applicable assets and cash evets to specific contacts or settlement instructions).
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractApplicablePartyProfileObjects", builder=AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl.class, version="${project.version}")
public interface AbstractApplicablePartyProfileObjects extends RosettaModelObject {

	AbstractApplicablePartyProfileObjectsMeta metaData = new AbstractApplicablePartyProfileObjectsMeta();

	/*********************** Getter Methods  ***********************/
	AssociationToAssetIdentifier getIdentifier();
	/**
	 * A structure which describes the applicable assets.
	 */
	ApplicableAssets getApplicableAssets();
	/**
	 * A scheme which defines the types of applicable transactions.
	 */
	List<? extends ApplicableTransactionType> getApplicableTransactions();

	/*********************** Build Methods  ***********************/
	AbstractApplicablePartyProfileObjects build();
	
	AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder();
	
	static AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder() {
		return new AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractApplicablePartyProfileObjects> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractApplicablePartyProfileObjects> getType() {
		return AbstractApplicablePartyProfileObjects.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.class, getApplicableTransactions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractApplicablePartyProfileObjectsBuilder extends AbstractApplicablePartyProfileObjects, RosettaModelObjectBuilder {
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getOrCreateIdentifier();
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getIdentifier();
		ApplicableAssets.ApplicableAssetsBuilder getOrCreateApplicableAssets();
		ApplicableAssets.ApplicableAssetsBuilder getApplicableAssets();
		ApplicableTransactionType.ApplicableTransactionTypeBuilder getOrCreateApplicableTransactions(int _index);
		List<? extends ApplicableTransactionType.ApplicableTransactionTypeBuilder> getApplicableTransactions();
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions0);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions1, int _idx);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions2);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.ApplicableTransactionTypeBuilder.class, getApplicableTransactions());
		}
		

		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractApplicablePartyProfileObjects  ***********************/
	class AbstractApplicablePartyProfileObjectsImpl implements AbstractApplicablePartyProfileObjects {
		private final AssociationToAssetIdentifier identifier;
		private final ApplicableAssets applicableAssets;
		private final List<? extends ApplicableTransactionType> applicableTransactions;
		
		protected AbstractApplicablePartyProfileObjectsImpl(AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.applicableAssets = ofNullable(builder.getApplicableAssets()).map(f->f.build()).orElse(null);
			this.applicableTransactions = ofNullable(builder.getApplicableTransactions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		public AssociationToAssetIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("applicableAssets")
		public ApplicableAssets getApplicableAssets() {
			return applicableAssets;
		}
		
		@Override
		@RosettaAttribute("applicableTransactions")
		public List<? extends ApplicableTransactionType> getApplicableTransactions() {
			return applicableTransactions;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects build() {
			return this;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder() {
			AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getApplicableAssets()).ifPresent(builder::setApplicableAssets);
			ofNullable(getApplicableTransactions()).ifPresent(builder::setApplicableTransactions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApplicablePartyProfileObjects _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(applicableAssets, _that.getApplicableAssets())) return false;
			if (!ListEquals.listEquals(applicableTransactions, _that.getApplicableTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (applicableAssets != null ? applicableAssets.hashCode() : 0);
			_result = 31 * _result + (applicableTransactions != null ? applicableTransactions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApplicablePartyProfileObjects {" +
				"identifier=" + this.identifier + ", " +
				"applicableAssets=" + this.applicableAssets + ", " +
				"applicableTransactions=" + this.applicableTransactions +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractApplicablePartyProfileObjects  ***********************/
	class AbstractApplicablePartyProfileObjectsBuilderImpl implements AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
	
		protected AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder identifier;
		protected ApplicableAssets.ApplicableAssetsBuilder applicableAssets;
		protected List<ApplicableTransactionType.ApplicableTransactionTypeBuilder> applicableTransactions = new ArrayList<>();
	
		public AbstractApplicablePartyProfileObjectsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getOrCreateIdentifier() {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = AssociationToAssetIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicableAssets")
		public ApplicableAssets.ApplicableAssetsBuilder getApplicableAssets() {
			return applicableAssets;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder getOrCreateApplicableAssets() {
			ApplicableAssets.ApplicableAssetsBuilder result;
			if (applicableAssets!=null) {
				result = applicableAssets;
			}
			else {
				result = applicableAssets = ApplicableAssets.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicableTransactions")
		public List<? extends ApplicableTransactionType.ApplicableTransactionTypeBuilder> getApplicableTransactions() {
			return applicableTransactions;
		}
		
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder getOrCreateApplicableTransactions(int _index) {
		
			if (applicableTransactions==null) {
				this.applicableTransactions = new ArrayList<>();
			}
			ApplicableTransactionType.ApplicableTransactionTypeBuilder result;
			return getIndex(applicableTransactions, _index, () -> {
						ApplicableTransactionType.ApplicableTransactionTypeBuilder newApplicableTransactions = ApplicableTransactionType.builder();
						return newApplicableTransactions;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setIdentifier(AssociationToAssetIdentifier identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("applicableAssets")
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableAssets(ApplicableAssets applicableAssets) {
			this.applicableAssets = applicableAssets==null?null:applicableAssets.toBuilder();
			return this;
		}
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions) {
			if (applicableTransactions!=null) this.applicableTransactions.add(applicableTransactions.toBuilder());
			return this;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions, int _idx) {
			getIndex(this.applicableTransactions, _idx, () -> applicableTransactions.toBuilder());
			return this;
		}
		@Override 
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss != null) {
				for (ApplicableTransactionType toAdd : applicableTransactionss) {
					this.applicableTransactions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("applicableTransactions")
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss == null)  {
				this.applicableTransactions = new ArrayList<>();
			}
			else {
				this.applicableTransactions = applicableTransactionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractApplicablePartyProfileObjects build() {
			return new AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl(this);
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (applicableAssets!=null && !applicableAssets.prune().hasData()) applicableAssets = null;
			applicableTransactions = applicableTransactions.stream().filter(b->b!=null).<ApplicableTransactionType.ApplicableTransactionTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			if (getApplicableAssets()!=null && getApplicableAssets().hasData()) return true;
			if (getApplicableTransactions()!=null && getApplicableTransactions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder o = (AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getApplicableAssets(), o.getApplicableAssets(), this::setApplicableAssets);
			merger.mergeRosetta(getApplicableTransactions(), o.getApplicableTransactions(), this::getOrCreateApplicableTransactions);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApplicablePartyProfileObjects _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(applicableAssets, _that.getApplicableAssets())) return false;
			if (!ListEquals.listEquals(applicableTransactions, _that.getApplicableTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (applicableAssets != null ? applicableAssets.hashCode() : 0);
			_result = 31 * _result + (applicableTransactions != null ? applicableTransactions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApplicablePartyProfileObjectsBuilder {" +
				"identifier=" + this.identifier + ", " +
				"applicableAssets=" + this.applicableAssets + ", " +
				"applicableTransactions=" + this.applicableTransactions +
			'}';
		}
	}
}
