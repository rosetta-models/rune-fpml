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
import fpml.confirmation.AdditionalData;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ExceptionModel.ExceptionModelBuilder;
import fpml.confirmation.ExceptionModel.ExceptionModelBuilderImpl;
import fpml.confirmation.ExceptionModel.ExceptionModelImpl;
import fpml.confirmation.Reason;
import fpml.confirmation.meta.ExceptionModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model group which has exception elements.
 * @version ${project.version}
 */
@RosettaDataType(value="ExceptionModel", builder=ExceptionModel.ExceptionModelBuilderImpl.class, version="${project.version}")
public interface ExceptionModel extends RosettaModelObject {

	ExceptionModelMeta metaData = new ExceptionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An instance of the Reason type used to record the nature of any errors associated with a message.
	 */
	List<? extends Reason> getReason();
	/**
	 * Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of the original request (within a CDATA section).
	 */
	AdditionalData getAdditionalData();

	/*********************** Build Methods  ***********************/
	ExceptionModel build();
	
	ExceptionModel.ExceptionModelBuilder toBuilder();
	
	static ExceptionModel.ExceptionModelBuilder builder() {
		return new ExceptionModel.ExceptionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExceptionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExceptionModel> getType() {
		return ExceptionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExceptionModelBuilder extends ExceptionModel, RosettaModelObjectBuilder {
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData();
		AdditionalData.AdditionalDataBuilder getAdditionalData();
		ExceptionModel.ExceptionModelBuilder addReason(Reason reason0);
		ExceptionModel.ExceptionModelBuilder addReason(Reason reason1, int _idx);
		ExceptionModel.ExceptionModelBuilder addReason(List<? extends Reason> reason2);
		ExceptionModel.ExceptionModelBuilder setReason(List<? extends Reason> reason3);
		ExceptionModel.ExceptionModelBuilder setAdditionalData(AdditionalData additionalData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
		}
		

		ExceptionModel.ExceptionModelBuilder prune();
	}

	/*********************** Immutable Implementation of ExceptionModel  ***********************/
	class ExceptionModelImpl implements ExceptionModel {
		private final List<? extends Reason> reason;
		private final AdditionalData additionalData;
		
		protected ExceptionModelImpl(ExceptionModel.ExceptionModelBuilder builder) {
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		public AdditionalData getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public ExceptionModel build() {
			return this;
		}
		
		@Override
		public ExceptionModel.ExceptionModelBuilder toBuilder() {
			ExceptionModel.ExceptionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExceptionModel.ExceptionModelBuilder builder) {
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExceptionModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionModel {" +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}

	/*********************** Builder Implementation of ExceptionModel  ***********************/
	class ExceptionModelBuilderImpl implements ExceptionModel.ExceptionModelBuilder {
	
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected AdditionalData.AdditionalDataBuilder additionalData;
	
		public ExceptionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			Reason.ReasonBuilder result;
			return getIndex(reason, _index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("additionalData")
		public AdditionalData.AdditionalDataBuilder getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData() {
			AdditionalData.AdditionalDataBuilder result;
			if (additionalData!=null) {
				result = additionalData;
			}
			else {
				result = additionalData = AdditionalData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reason")
		public ExceptionModel.ExceptionModelBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public ExceptionModel.ExceptionModelBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public ExceptionModel.ExceptionModelBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExceptionModel.ExceptionModelBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		public ExceptionModel.ExceptionModelBuilder setAdditionalData(AdditionalData additionalData) {
			this.additionalData = additionalData==null?null:additionalData.toBuilder();
			return this;
		}
		
		@Override
		public ExceptionModel build() {
			return new ExceptionModel.ExceptionModelImpl(this);
		}
		
		@Override
		public ExceptionModel.ExceptionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExceptionModel.ExceptionModelBuilder prune() {
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalData!=null && !additionalData.prune().hasData()) additionalData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalData()!=null && getAdditionalData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExceptionModel.ExceptionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExceptionModel.ExceptionModelBuilder o = (ExceptionModel.ExceptionModelBuilder) other;
			
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::setAdditionalData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExceptionModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionModelBuilder {" +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}
}
