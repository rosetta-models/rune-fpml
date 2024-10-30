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
import fpml.confirmation.PrincipalExchangeDescriptions;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder;
import fpml.confirmation.PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl;
import fpml.confirmation.PrincipalExchangeFeatures.PrincipalExchangeFeaturesImpl;
import fpml.confirmation.PrincipalExchanges;
import fpml.confirmation.meta.PrincipalExchangeFeaturesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing the principal exchange features of the return swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PrincipalExchangeFeatures", builder=PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PrincipalExchangeFeatures extends RosettaModelObject {

	PrincipalExchangeFeaturesMeta metaData = new PrincipalExchangeFeaturesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 */
	PrincipalExchanges getPrincipalExchanges();
	/**
	 * Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
	 */
	List<? extends PrincipalExchangeDescriptions> getPrincipalExchangeDescriptions();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeFeatures build();
	
	PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder();
	
	static PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder() {
		return new PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeFeatures> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrincipalExchangeFeatures> getType() {
		return PrincipalExchangeFeatures.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.class, getPrincipalExchanges());
		processRosetta(path.newSubPath("principalExchangeDescriptions"), processor, PrincipalExchangeDescriptions.class, getPrincipalExchangeDescriptions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeFeaturesBuilder extends PrincipalExchangeFeatures, RosettaModelObjectBuilder {
		PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges();
		PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges();
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder getOrCreatePrincipalExchangeDescriptions(int _index);
		List<? extends PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> getPrincipalExchangeDescriptions();
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions0);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions1, int _idx);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions2);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.PrincipalExchangesBuilder.class, getPrincipalExchanges());
			processRosetta(path.newSubPath("principalExchangeDescriptions"), processor, PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder.class, getPrincipalExchangeDescriptions());
		}
		

		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeFeatures  ***********************/
	class PrincipalExchangeFeaturesImpl implements PrincipalExchangeFeatures {
		private final PrincipalExchanges principalExchanges;
		private final List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions;
		
		protected PrincipalExchangeFeaturesImpl(PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder) {
			this.principalExchanges = ofNullable(builder.getPrincipalExchanges()).map(f->f.build()).orElse(null);
			this.principalExchangeDescriptions = ofNullable(builder.getPrincipalExchangeDescriptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		public PrincipalExchanges getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDescriptions")
		public List<? extends PrincipalExchangeDescriptions> getPrincipalExchangeDescriptions() {
			return principalExchangeDescriptions;
		}
		
		@Override
		public PrincipalExchangeFeatures build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder() {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder) {
			ofNullable(getPrincipalExchanges()).ifPresent(builder::setPrincipalExchanges);
			ofNullable(getPrincipalExchangeDescriptions()).ifPresent(builder::setPrincipalExchangeDescriptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeFeatures _that = getType().cast(o);
		
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!ListEquals.listEquals(principalExchangeDescriptions, _that.getPrincipalExchangeDescriptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDescriptions != null ? principalExchangeDescriptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeFeatures {" +
				"principalExchanges=" + this.principalExchanges + ", " +
				"principalExchangeDescriptions=" + this.principalExchangeDescriptions +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeFeatures  ***********************/
	class PrincipalExchangeFeaturesBuilderImpl implements PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder {
	
		protected PrincipalExchanges.PrincipalExchangesBuilder principalExchanges;
		protected List<PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> principalExchangeDescriptions = new ArrayList<>();
	
		public PrincipalExchangeFeaturesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("principalExchanges")
		public PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges() {
			PrincipalExchanges.PrincipalExchangesBuilder result;
			if (principalExchanges!=null) {
				result = principalExchanges;
			}
			else {
				result = principalExchanges = PrincipalExchanges.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDescriptions")
		public List<? extends PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> getPrincipalExchangeDescriptions() {
			return principalExchangeDescriptions;
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder getOrCreatePrincipalExchangeDescriptions(int _index) {
		
			if (principalExchangeDescriptions==null) {
				this.principalExchangeDescriptions = new ArrayList<>();
			}
			PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder result;
			return getIndex(principalExchangeDescriptions, _index, () -> {
						PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder newPrincipalExchangeDescriptions = PrincipalExchangeDescriptions.builder();
						return newPrincipalExchangeDescriptions;
					});
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges) {
			this.principalExchanges = principalExchanges==null?null:principalExchanges.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalExchangeDescriptions")
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions) {
			if (principalExchangeDescriptions!=null) this.principalExchangeDescriptions.add(principalExchangeDescriptions.toBuilder());
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions, int _idx) {
			getIndex(this.principalExchangeDescriptions, _idx, () -> principalExchangeDescriptions.toBuilder());
			return this;
		}
		@Override 
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptionss) {
			if (principalExchangeDescriptionss != null) {
				for (PrincipalExchangeDescriptions toAdd : principalExchangeDescriptionss) {
					this.principalExchangeDescriptions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptionss) {
			if (principalExchangeDescriptionss == null)  {
				this.principalExchangeDescriptions = new ArrayList<>();
			}
			else {
				this.principalExchangeDescriptions = principalExchangeDescriptionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PrincipalExchangeFeatures build() {
			return new PrincipalExchangeFeatures.PrincipalExchangeFeaturesImpl(this);
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder prune() {
			if (principalExchanges!=null && !principalExchanges.prune().hasData()) principalExchanges = null;
			principalExchangeDescriptions = principalExchangeDescriptions.stream().filter(b->b!=null).<PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrincipalExchanges()!=null && getPrincipalExchanges().hasData()) return true;
			if (getPrincipalExchangeDescriptions()!=null && getPrincipalExchangeDescriptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder o = (PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder) other;
			
			merger.mergeRosetta(getPrincipalExchanges(), o.getPrincipalExchanges(), this::setPrincipalExchanges);
			merger.mergeRosetta(getPrincipalExchangeDescriptions(), o.getPrincipalExchangeDescriptions(), this::getOrCreatePrincipalExchangeDescriptions);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeFeatures _that = getType().cast(o);
		
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!ListEquals.listEquals(principalExchangeDescriptions, _that.getPrincipalExchangeDescriptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDescriptions != null ? principalExchangeDescriptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeFeaturesBuilder {" +
				"principalExchanges=" + this.principalExchanges + ", " +
				"principalExchangeDescriptions=" + this.principalExchangeDescriptions +
			'}';
		}
	}
}
