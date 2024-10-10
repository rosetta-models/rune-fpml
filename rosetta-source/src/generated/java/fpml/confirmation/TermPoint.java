package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BidMidAskModel;
import fpml.confirmation.TermPoint;
import fpml.confirmation.TermPoint.TermPointBuilder;
import fpml.confirmation.TermPoint.TermPointBuilderImpl;
import fpml.confirmation.TermPoint.TermPointImpl;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.meta.TermPointMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A value point that can have a time dimension. Allows bid, mid, ask, and spread values to be represented.
 * @version ${project.version}
 */
@RosettaDataType(value="TermPoint", builder=TermPoint.TermPointBuilderImpl.class, version="${project.version}")
public interface TermPoint extends RosettaModelObject {

	TermPointMeta metaData = new TermPointMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time dimension of the point (tenor and/or date)
	 */
	TimeDimension getTerm();
	BidMidAskModel getBidMidAskModel();
	/**
	 * The spread value can be used in conjunction with the &quot;mid&quot; value to define the bid and the ask value.
	 */
	BigDecimal getSpreadValue();
	/**
	 * An optional reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a discount instrument.
	 */
	AssetReference getDefinition();
	String getId();

	/*********************** Build Methods  ***********************/
	TermPoint build();
	
	TermPoint.TermPointBuilder toBuilder();
	
	static TermPoint.TermPointBuilder builder() {
		return new TermPoint.TermPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TermPoint> getType() {
		return TermPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processRosetta(path.newSubPath("bidMidAskModel"), processor, BidMidAskModel.class, getBidMidAskModel());
		processor.processBasic(path.newSubPath("spreadValue"), BigDecimal.class, getSpreadValue(), this);
		processRosetta(path.newSubPath("definition"), processor, AssetReference.class, getDefinition());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermPointBuilder extends TermPoint, RosettaModelObjectBuilder {
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		TimeDimension.TimeDimensionBuilder getTerm();
		BidMidAskModel.BidMidAskModelBuilder getOrCreateBidMidAskModel();
		BidMidAskModel.BidMidAskModelBuilder getBidMidAskModel();
		AssetReference.AssetReferenceBuilder getOrCreateDefinition();
		AssetReference.AssetReferenceBuilder getDefinition();
		TermPoint.TermPointBuilder setTerm(TimeDimension term);
		TermPoint.TermPointBuilder setBidMidAskModel(BidMidAskModel bidMidAskModel);
		TermPoint.TermPointBuilder setSpreadValue(BigDecimal spreadValue);
		TermPoint.TermPointBuilder setDefinition(AssetReference definition);
		TermPoint.TermPointBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processRosetta(path.newSubPath("bidMidAskModel"), processor, BidMidAskModel.BidMidAskModelBuilder.class, getBidMidAskModel());
			processor.processBasic(path.newSubPath("spreadValue"), BigDecimal.class, getSpreadValue(), this);
			processRosetta(path.newSubPath("definition"), processor, AssetReference.AssetReferenceBuilder.class, getDefinition());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TermPoint.TermPointBuilder prune();
	}

	/*********************** Immutable Implementation of TermPoint  ***********************/
	class TermPointImpl implements TermPoint {
		private final TimeDimension term;
		private final BidMidAskModel bidMidAskModel;
		private final BigDecimal spreadValue;
		private final AssetReference definition;
		private final String id;
		
		protected TermPointImpl(TermPoint.TermPointBuilder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.bidMidAskModel = ofNullable(builder.getBidMidAskModel()).map(f->f.build()).orElse(null);
			this.spreadValue = builder.getSpreadValue();
			this.definition = ofNullable(builder.getDefinition()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("bidMidAskModel")
		public BidMidAskModel getBidMidAskModel() {
			return bidMidAskModel;
		}
		
		@Override
		@RosettaAttribute("spreadValue")
		public BigDecimal getSpreadValue() {
			return spreadValue;
		}
		
		@Override
		@RosettaAttribute("definition")
		public AssetReference getDefinition() {
			return definition;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TermPoint build() {
			return this;
		}
		
		@Override
		public TermPoint.TermPointBuilder toBuilder() {
			TermPoint.TermPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermPoint.TermPointBuilder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getBidMidAskModel()).ifPresent(builder::setBidMidAskModel);
			ofNullable(getSpreadValue()).ifPresent(builder::setSpreadValue);
			ofNullable(getDefinition()).ifPresent(builder::setDefinition);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermPoint _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(bidMidAskModel, _that.getBidMidAskModel())) return false;
			if (!Objects.equals(spreadValue, _that.getSpreadValue())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (bidMidAskModel != null ? bidMidAskModel.hashCode() : 0);
			_result = 31 * _result + (spreadValue != null ? spreadValue.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermPoint {" +
				"term=" + this.term + ", " +
				"bidMidAskModel=" + this.bidMidAskModel + ", " +
				"spreadValue=" + this.spreadValue + ", " +
				"definition=" + this.definition + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TermPoint  ***********************/
	class TermPointBuilderImpl implements TermPoint.TermPointBuilder {
	
		protected TimeDimension.TimeDimensionBuilder term;
		protected BidMidAskModel.BidMidAskModelBuilder bidMidAskModel;
		protected BigDecimal spreadValue;
		protected AssetReference.AssetReferenceBuilder definition;
		protected String id;
	
		public TermPointBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bidMidAskModel")
		public BidMidAskModel.BidMidAskModelBuilder getBidMidAskModel() {
			return bidMidAskModel;
		}
		
		@Override
		public BidMidAskModel.BidMidAskModelBuilder getOrCreateBidMidAskModel() {
			BidMidAskModel.BidMidAskModelBuilder result;
			if (bidMidAskModel!=null) {
				result = bidMidAskModel;
			}
			else {
				result = bidMidAskModel = BidMidAskModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadValue")
		public BigDecimal getSpreadValue() {
			return spreadValue;
		}
		
		@Override
		@RosettaAttribute("definition")
		public AssetReference.AssetReferenceBuilder getDefinition() {
			return definition;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateDefinition() {
			AssetReference.AssetReferenceBuilder result;
			if (definition!=null) {
				result = definition;
			}
			else {
				result = definition = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("term")
		public TermPoint.TermPointBuilder setTerm(TimeDimension term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bidMidAskModel")
		public TermPoint.TermPointBuilder setBidMidAskModel(BidMidAskModel bidMidAskModel) {
			this.bidMidAskModel = bidMidAskModel==null?null:bidMidAskModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spreadValue")
		public TermPoint.TermPointBuilder setSpreadValue(BigDecimal spreadValue) {
			this.spreadValue = spreadValue==null?null:spreadValue;
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public TermPoint.TermPointBuilder setDefinition(AssetReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TermPoint.TermPointBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public TermPoint build() {
			return new TermPoint.TermPointImpl(this);
		}
		
		@Override
		public TermPoint.TermPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermPoint.TermPointBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			if (bidMidAskModel!=null && !bidMidAskModel.prune().hasData()) bidMidAskModel = null;
			if (definition!=null && !definition.prune().hasData()) definition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getBidMidAskModel()!=null && getBidMidAskModel().hasData()) return true;
			if (getSpreadValue()!=null) return true;
			if (getDefinition()!=null && getDefinition().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermPoint.TermPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TermPoint.TermPointBuilder o = (TermPoint.TermPointBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getBidMidAskModel(), o.getBidMidAskModel(), this::setBidMidAskModel);
			merger.mergeRosetta(getDefinition(), o.getDefinition(), this::setDefinition);
			
			merger.mergeBasic(getSpreadValue(), o.getSpreadValue(), this::setSpreadValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermPoint _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(bidMidAskModel, _that.getBidMidAskModel())) return false;
			if (!Objects.equals(spreadValue, _that.getSpreadValue())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (bidMidAskModel != null ? bidMidAskModel.hashCode() : 0);
			_result = 31 * _result + (spreadValue != null ? spreadValue.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermPointBuilder {" +
				"term=" + this.term + ", " +
				"bidMidAskModel=" + this.bidMidAskModel + ", " +
				"spreadValue=" + this.spreadValue + ", " +
				"definition=" + this.definition + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
