package fpml.confirmation.v5.staticgroup;

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
import fpml.confirmation.v5.staticgroup.meta.PartyModelMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model group with the content model of a party.
 * @version 0.0.0
 */
@RosettaDataType(value="PartyModel", builder=PartyModel.PartyModelBuilderImpl.class, version="0.0.0")
public interface PartyModel extends RosettaModelObject {

	PartyModelMeta metaData = new PartyModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party identifier, e.g. a S.W.I.F.T. bank identifier code (BIC).
	 */
	List<? extends PartyId> getPartyId();
	/**
	 * The legal name of the organization. A free format string. FpML does not define usage rules for this element.
	 */
	PartyName getPartyName();

	/*********************** Build Methods  ***********************/
	PartyModel build();
	
	PartyModelBuilder toBuilder();
	
	static PartyModelBuilder builder() {
		return new PartyModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyModel> getType() {
		return PartyModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyId"), processor, PartyId.class, getPartyId());
		processRosetta(path.newSubPath("partyName"), processor, PartyName.class, getPartyName());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyModelBuilder extends PartyModel, RosettaModelObjectBuilder {
		PartyId.PartyIdBuilder getOrCreatePartyId(int _index);
		List<? extends PartyId.PartyIdBuilder> getPartyId();
		PartyName.PartyNameBuilder getOrCreatePartyName();
		PartyName.PartyNameBuilder getPartyName();
		PartyModelBuilder addPartyId(PartyId partyId0);
		PartyModelBuilder addPartyId(PartyId partyId1, int _idx);
		PartyModelBuilder addPartyId(List<? extends PartyId> partyId2);
		PartyModelBuilder setPartyId(List<? extends PartyId> partyId3);
		PartyModelBuilder setPartyName(PartyName partyName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyId"), processor, PartyId.PartyIdBuilder.class, getPartyId());
			processRosetta(path.newSubPath("partyName"), processor, PartyName.PartyNameBuilder.class, getPartyName());
		}
		

		PartyModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartyModel  ***********************/
	class PartyModelImpl implements PartyModel {
		private final List<? extends PartyId> partyId;
		private final PartyName partyName;
		
		protected PartyModelImpl(PartyModelBuilder builder) {
			this.partyId = ofNullable(builder.getPartyId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyName = ofNullable(builder.getPartyName()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyId")
		public List<? extends PartyId> getPartyId() {
			return partyId;
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyName getPartyName() {
			return partyName;
		}
		
		@Override
		public PartyModel build() {
			return this;
		}
		
		@Override
		public PartyModelBuilder toBuilder() {
			PartyModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyModelBuilder builder) {
			ofNullable(getPartyId()).ifPresent(builder::setPartyId);
			ofNullable(getPartyName()).ifPresent(builder::setPartyName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyModel {" +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyModel  ***********************/
	class PartyModelBuilderImpl implements PartyModelBuilder {
	
		protected List<PartyId.PartyIdBuilder> partyId = new ArrayList<>();
		protected PartyName.PartyNameBuilder partyName;
	
		public PartyModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyId")
		public List<? extends PartyId.PartyIdBuilder> getPartyId() {
			return partyId;
		}
		
		public PartyId.PartyIdBuilder getOrCreatePartyId(int _index) {
		
			if (partyId==null) {
				this.partyId = new ArrayList<>();
			}
			PartyId.PartyIdBuilder result;
			return getIndex(partyId, _index, () -> {
						PartyId.PartyIdBuilder newPartyId = PartyId.builder();
						return newPartyId;
					});
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyName.PartyNameBuilder getPartyName() {
			return partyName;
		}
		
		@Override
		public PartyName.PartyNameBuilder getOrCreatePartyName() {
			PartyName.PartyNameBuilder result;
			if (partyName!=null) {
				result = partyName;
			}
			else {
				result = partyName = PartyName.builder();
			}
			
			return result;
		}
		
		@Override
		public PartyModelBuilder addPartyId(PartyId partyId) {
			if (partyId!=null) this.partyId.add(partyId.toBuilder());
			return this;
		}
		
		@Override
		public PartyModelBuilder addPartyId(PartyId partyId, int _idx) {
			getIndex(this.partyId, _idx, () -> partyId.toBuilder());
			return this;
		}
		@Override 
		public PartyModelBuilder addPartyId(List<? extends PartyId> partyIds) {
			if (partyIds != null) {
				for (PartyId toAdd : partyIds) {
					this.partyId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyId")
		public PartyModelBuilder setPartyId(List<? extends PartyId> partyIds) {
			if (partyIds == null)  {
				this.partyId = new ArrayList<>();
			}
			else {
				this.partyId = partyIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyModelBuilder setPartyName(PartyName partyName) {
			this.partyName = partyName==null?null:partyName.toBuilder();
			return this;
		}
		
		@Override
		public PartyModel build() {
			return new PartyModelImpl(this);
		}
		
		@Override
		public PartyModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyModelBuilder prune() {
			partyId = partyId.stream().filter(b->b!=null).<PartyId.PartyIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyName!=null && !partyName.prune().hasData()) partyName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyId()!=null && getPartyId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyName()!=null && getPartyName().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyModelBuilder o = (PartyModelBuilder) other;
			
			merger.mergeRosetta(getPartyId(), o.getPartyId(), this::getOrCreatePartyId);
			merger.mergeRosetta(getPartyName(), o.getPartyName(), this::setPartyName);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyModelBuilder {" +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName +
			'}';
		}
	}
}
