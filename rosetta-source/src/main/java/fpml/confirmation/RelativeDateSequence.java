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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DateOffset;
import fpml.confirmation.DateReference;
import fpml.confirmation.RelativeDateSequence;
import fpml.confirmation.RelativeDateSequence.RelativeDateSequenceBuilder;
import fpml.confirmation.RelativeDateSequence.RelativeDateSequenceBuilderImpl;
import fpml.confirmation.RelativeDateSequence.RelativeDateSequenceImpl;
import fpml.confirmation.meta.RelativeDateSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing a date when this date is defined in reference to another date through one or several date offsets.
 * @version ${project.version}
 */
@RosettaDataType(value="RelativeDateSequence", builder=RelativeDateSequence.RelativeDateSequenceBuilderImpl.class, version="${project.version}")
public interface RelativeDateSequence extends RosettaModelObject {

	RelativeDateSequenceMeta metaData = new RelativeDateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 */
	DateReference getDateRelativeTo();
	List<? extends DateOffset> getDateOffset();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();

	/*********************** Build Methods  ***********************/
	RelativeDateSequence build();
	
	RelativeDateSequence.RelativeDateSequenceBuilder toBuilder();
	
	static RelativeDateSequence.RelativeDateSequenceBuilder builder() {
		return new RelativeDateSequence.RelativeDateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RelativeDateSequence> getType() {
		return RelativeDateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.class, getDateOffset());
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDateSequenceBuilder extends RelativeDateSequence, RosettaModelObjectBuilder {
		DateReference.DateReferenceBuilder getOrCreateDateRelativeTo();
		DateReference.DateReferenceBuilder getDateRelativeTo();
		DateOffset.DateOffsetBuilder getOrCreateDateOffset(int _index);
		List<? extends DateOffset.DateOffsetBuilder> getDateOffset();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		RelativeDateSequence.RelativeDateSequenceBuilder setDateRelativeTo(DateReference dateRelativeTo);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset0);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset1, int _idx);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(List<? extends DateOffset> dateOffset2);
		RelativeDateSequence.RelativeDateSequenceBuilder setDateOffset(List<? extends DateOffset> dateOffset3);
		RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.DateOffsetBuilder.class, getDateOffset());
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
		}
		

		RelativeDateSequence.RelativeDateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDateSequence  ***********************/
	class RelativeDateSequenceImpl implements RelativeDateSequence {
		private final DateReference dateRelativeTo;
		private final List<? extends DateOffset> dateOffset;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		
		protected RelativeDateSequenceImpl(RelativeDateSequence.RelativeDateSequenceBuilder builder) {
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.dateOffset = ofNullable(builder.getDateOffset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public DateReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		public List<? extends DateOffset> getDateOffset() {
			return dateOffset;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public RelativeDateSequence build() {
			return this;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder toBuilder() {
			RelativeDateSequence.RelativeDateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateSequence.RelativeDateSequenceBuilder builder) {
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getDateOffset()).ifPresent(builder::setDateOffset);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!ListEquals.listEquals(dateOffset, _that.getDateOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateSequence {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of RelativeDateSequence  ***********************/
	class RelativeDateSequenceBuilderImpl implements RelativeDateSequence.RelativeDateSequenceBuilder {
	
		protected DateReference.DateReferenceBuilder dateRelativeTo;
		protected List<DateOffset.DateOffsetBuilder> dateOffset = new ArrayList<>();
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
	
		public RelativeDateSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dateRelativeTo")
		public DateReference.DateReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDateRelativeTo() {
			DateReference.DateReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		public List<? extends DateOffset.DateOffsetBuilder> getDateOffset() {
			return dateOffset;
		}
		
		public DateOffset.DateOffsetBuilder getOrCreateDateOffset(int _index) {
		
			if (dateOffset==null) {
				this.dateOffset = new ArrayList<>();
			}
			DateOffset.DateOffsetBuilder result;
			return getIndex(dateOffset, _index, () -> {
						DateOffset.DateOffsetBuilder newDateOffset = DateOffset.builder();
						return newDateOffset;
					});
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public RelativeDateSequence.RelativeDateSequenceBuilder setDateRelativeTo(DateReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset) {
			if (dateOffset!=null) this.dateOffset.add(dateOffset.toBuilder());
			return this;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset, int _idx) {
			getIndex(this.dateOffset, _idx, () -> dateOffset.toBuilder());
			return this;
		}
		@Override 
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(List<? extends DateOffset> dateOffsets) {
			if (dateOffsets != null) {
				for (DateOffset toAdd : dateOffsets) {
					this.dateOffset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("dateOffset")
		public RelativeDateSequence.RelativeDateSequenceBuilder setDateOffset(List<? extends DateOffset> dateOffsets) {
			if (dateOffsets == null)  {
				this.dateOffset = new ArrayList<>();
			}
			else {
				this.dateOffset = dateOffsets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateSequence build() {
			return new RelativeDateSequence.RelativeDateSequenceImpl(this);
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder prune() {
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			dateOffset = dateOffset.stream().filter(b->b!=null).<DateOffset.DateOffsetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getDateOffset()!=null && getDateOffset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelativeDateSequence.RelativeDateSequenceBuilder o = (RelativeDateSequence.RelativeDateSequenceBuilder) other;
			
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getDateOffset(), o.getDateOffset(), this::getOrCreateDateOffset);
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!ListEquals.listEquals(dateOffset, _that.getDateOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateSequenceBuilder {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}';
		}
	}
}
