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
import fpml.confirmation.ElectricityTransmissionContingency;
import fpml.confirmation.ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder;
import fpml.confirmation.ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl;
import fpml.confirmation.ElectricityTransmissionContingency.ElectricityTransmissionContingencyImpl;
import fpml.confirmation.ElectricityTransmissionContingencyType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.ElectricityTransmissionContingencyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure to specify the tranmission contingency and the party that bears the obligation.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityTransmissionContingency", builder=ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl.class, version="${project.version}")
public interface ElectricityTransmissionContingency extends RosettaModelObject {

	ElectricityTransmissionContingencyMeta metaData = new ElectricityTransmissionContingencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The conditions under which the party specified in contingentParty will be excused from damages if transmission is interrupted or curtailed.
	 */
	ElectricityTransmissionContingencyType getContingency();
	/**
	 * The party to which the contingency applies.
	 */
	List<? extends PartyReference> getContingentParty();

	/*********************** Build Methods  ***********************/
	ElectricityTransmissionContingency build();
	
	ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder();
	
	static ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder() {
		return new ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityTransmissionContingency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityTransmissionContingency> getType() {
		return ElectricityTransmissionContingency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contingency"), processor, ElectricityTransmissionContingencyType.class, getContingency());
		processRosetta(path.newSubPath("contingentParty"), processor, PartyReference.class, getContingentParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityTransmissionContingencyBuilder extends ElectricityTransmissionContingency, RosettaModelObjectBuilder {
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getOrCreateContingency();
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getContingency();
		PartyReference.PartyReferenceBuilder getOrCreateContingentParty(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getContingentParty();
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingency(ElectricityTransmissionContingencyType contingency);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty0);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty1, int _idx);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(List<? extends PartyReference> contingentParty2);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingentParty(List<? extends PartyReference> contingentParty3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contingency"), processor, ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder.class, getContingency());
			processRosetta(path.newSubPath("contingentParty"), processor, PartyReference.PartyReferenceBuilder.class, getContingentParty());
		}
		

		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityTransmissionContingency  ***********************/
	class ElectricityTransmissionContingencyImpl implements ElectricityTransmissionContingency {
		private final ElectricityTransmissionContingencyType contingency;
		private final List<? extends PartyReference> contingentParty;
		
		protected ElectricityTransmissionContingencyImpl(ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder) {
			this.contingency = ofNullable(builder.getContingency()).map(f->f.build()).orElse(null);
			this.contingentParty = ofNullable(builder.getContingentParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contingency")
		public ElectricityTransmissionContingencyType getContingency() {
			return contingency;
		}
		
		@Override
		@RosettaAttribute("contingentParty")
		public List<? extends PartyReference> getContingentParty() {
			return contingentParty;
		}
		
		@Override
		public ElectricityTransmissionContingency build() {
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder() {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder) {
			ofNullable(getContingency()).ifPresent(builder::setContingency);
			ofNullable(getContingentParty()).ifPresent(builder::setContingentParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingency _that = getType().cast(o);
		
			if (!Objects.equals(contingency, _that.getContingency())) return false;
			if (!ListEquals.listEquals(contingentParty, _that.getContingentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contingency != null ? contingency.hashCode() : 0);
			_result = 31 * _result + (contingentParty != null ? contingentParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingency {" +
				"contingency=" + this.contingency + ", " +
				"contingentParty=" + this.contingentParty +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityTransmissionContingency  ***********************/
	class ElectricityTransmissionContingencyBuilderImpl implements ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder {
	
		protected ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder contingency;
		protected List<PartyReference.PartyReferenceBuilder> contingentParty = new ArrayList<>();
	
		public ElectricityTransmissionContingencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("contingency")
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getContingency() {
			return contingency;
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getOrCreateContingency() {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder result;
			if (contingency!=null) {
				result = contingency;
			}
			else {
				result = contingency = ElectricityTransmissionContingencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contingentParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getContingentParty() {
			return contingentParty;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreateContingentParty(int _index) {
		
			if (contingentParty==null) {
				this.contingentParty = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(contingentParty, _index, () -> {
						PartyReference.PartyReferenceBuilder newContingentParty = PartyReference.builder();
						return newContingentParty;
					});
		}
		
		@Override
		@RosettaAttribute("contingency")
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingency(ElectricityTransmissionContingencyType contingency) {
			this.contingency = contingency==null?null:contingency.toBuilder();
			return this;
		}
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty) {
			if (contingentParty!=null) this.contingentParty.add(contingentParty.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty, int _idx) {
			getIndex(this.contingentParty, _idx, () -> contingentParty.toBuilder());
			return this;
		}
		@Override 
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(List<? extends PartyReference> contingentPartys) {
			if (contingentPartys != null) {
				for (PartyReference toAdd : contingentPartys) {
					this.contingentParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contingentParty")
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingentParty(List<? extends PartyReference> contingentPartys) {
			if (contingentPartys == null)  {
				this.contingentParty = new ArrayList<>();
			}
			else {
				this.contingentParty = contingentPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ElectricityTransmissionContingency build() {
			return new ElectricityTransmissionContingency.ElectricityTransmissionContingencyImpl(this);
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder prune() {
			if (contingency!=null && !contingency.prune().hasData()) contingency = null;
			contingentParty = contingentParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContingency()!=null && getContingency().hasData()) return true;
			if (getContingentParty()!=null && getContingentParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder o = (ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder) other;
			
			merger.mergeRosetta(getContingency(), o.getContingency(), this::setContingency);
			merger.mergeRosetta(getContingentParty(), o.getContingentParty(), this::getOrCreateContingentParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingency _that = getType().cast(o);
		
			if (!Objects.equals(contingency, _that.getContingency())) return false;
			if (!ListEquals.listEquals(contingentParty, _that.getContingentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contingency != null ? contingency.hashCode() : 0);
			_result = 31 * _result + (contingentParty != null ? contingentParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyBuilder {" +
				"contingency=" + this.contingency + ", " +
				"contingentParty=" + this.contingentParty +
			'}';
		}
	}
}
