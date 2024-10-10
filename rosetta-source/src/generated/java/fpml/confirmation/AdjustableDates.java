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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableDates.AdjustableDatesBuilder;
import fpml.confirmation.AdjustableDates.AdjustableDatesBuilderImpl;
import fpml.confirmation.AdjustableDates.AdjustableDatesImpl;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.AdjustableDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableDates", builder=AdjustableDates.AdjustableDatesBuilderImpl.class, version="${project.version}")
public interface AdjustableDates extends RosettaModelObject {

	AdjustableDatesMeta metaData = new AdjustableDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment.
	 */
	List<? extends IdentifiedDate> getUnadjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business dat in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	List<? extends IdentifiedDate> getAdjustedDate();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableDates build();
	
	AdjustableDates.AdjustableDatesBuilder toBuilder();
	
	static AdjustableDates.AdjustableDatesBuilder builder() {
		return new AdjustableDates.AdjustableDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDates> getType() {
		return AdjustableDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDatesBuilder extends AdjustableDates, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate(int _index);
		List<? extends IdentifiedDate.IdentifiedDateBuilder> getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate(int _index);
		List<? extends IdentifiedDate.IdentifiedDateBuilder> getAdjustedDate();
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate0);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate1, int _idx);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends IdentifiedDate> unadjustedDate2);
		AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends IdentifiedDate> unadjustedDate3);
		AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate0);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate1, int _idx);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends IdentifiedDate> adjustedDate2);
		AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends IdentifiedDate> adjustedDate3);
		AdjustableDates.AdjustableDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableDates.AdjustableDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDates  ***********************/
	class AdjustableDatesImpl implements AdjustableDates {
		private final List<? extends IdentifiedDate> unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final List<? extends IdentifiedDate> adjustedDate;
		private final String id;
		
		protected AdjustableDatesImpl(AdjustableDates.AdjustableDatesBuilder builder) {
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		public List<? extends IdentifiedDate> getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<? extends IdentifiedDate> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableDates build() {
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			AdjustableDates.AdjustableDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDates.AdjustableDatesBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDates {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDates  ***********************/
	class AdjustableDatesBuilderImpl implements AdjustableDates.AdjustableDatesBuilder {
	
		protected List<IdentifiedDate.IdentifiedDateBuilder> unadjustedDate = new ArrayList<>();
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<IdentifiedDate.IdentifiedDateBuilder> adjustedDate = new ArrayList<>();
		protected String id;
	
		public AdjustableDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedDate")
		public List<? extends IdentifiedDate.IdentifiedDateBuilder> getUnadjustedDate() {
			return unadjustedDate;
		}
		
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate(int _index) {
		
			if (unadjustedDate==null) {
				this.unadjustedDate = new ArrayList<>();
			}
			IdentifiedDate.IdentifiedDateBuilder result;
			return getIndex(unadjustedDate, _index, () -> {
						IdentifiedDate.IdentifiedDateBuilder newUnadjustedDate = IdentifiedDate.builder();
						return newUnadjustedDate;
					});
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<? extends IdentifiedDate.IdentifiedDateBuilder> getAdjustedDate() {
			return adjustedDate;
		}
		
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate(int _index) {
		
			if (adjustedDate==null) {
				this.adjustedDate = new ArrayList<>();
			}
			IdentifiedDate.IdentifiedDateBuilder result;
			return getIndex(adjustedDate, _index, () -> {
						IdentifiedDate.IdentifiedDateBuilder newAdjustedDate = IdentifiedDate.builder();
						return newAdjustedDate;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate) {
			if (unadjustedDate!=null) this.unadjustedDate.add(unadjustedDate.toBuilder());
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate, int _idx) {
			getIndex(this.unadjustedDate, _idx, () -> unadjustedDate.toBuilder());
			return this;
		}
		@Override 
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends IdentifiedDate> unadjustedDates) {
			if (unadjustedDates != null) {
				for (IdentifiedDate toAdd : unadjustedDates) {
					this.unadjustedDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("unadjustedDate")
		public AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends IdentifiedDate> unadjustedDates) {
			if (unadjustedDates == null)  {
				this.unadjustedDate = new ArrayList<>();
			}
			else {
				this.unadjustedDate = unadjustedDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate) {
			if (adjustedDate!=null) this.adjustedDate.add(adjustedDate.toBuilder());
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate, int _idx) {
			getIndex(this.adjustedDate, _idx, () -> adjustedDate.toBuilder());
			return this;
		}
		@Override 
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends IdentifiedDate> adjustedDates) {
			if (adjustedDates != null) {
				for (IdentifiedDate toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("adjustedDate")
		public AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends IdentifiedDate> adjustedDates) {
			if (adjustedDates == null)  {
				this.adjustedDate = new ArrayList<>();
			}
			else {
				this.adjustedDate = adjustedDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public AdjustableDates.AdjustableDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableDates build() {
			return new AdjustableDates.AdjustableDatesImpl(this);
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder prune() {
			unadjustedDate = unadjustedDate.stream().filter(b->b!=null).<IdentifiedDate.IdentifiedDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			adjustedDate = adjustedDate.stream().filter(b->b!=null).<IdentifiedDate.IdentifiedDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null && getUnadjustedDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDates.AdjustableDatesBuilder o = (AdjustableDates.AdjustableDatesBuilder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::getOrCreateUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::getOrCreateAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDatesBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
