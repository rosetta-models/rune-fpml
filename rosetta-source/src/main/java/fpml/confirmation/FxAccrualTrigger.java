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
import fpml.confirmation.FxAccrualTrigger;
import fpml.confirmation.FxAccrualTrigger.FxAccrualTriggerBuilder;
import fpml.confirmation.FxAccrualTrigger.FxAccrualTriggerBuilderImpl;
import fpml.confirmation.FxAccrualTrigger.FxAccrualTriggerImpl;
import fpml.confirmation.FxTriggerBase;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseBuilder;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseBuilderImpl;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseImpl;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.meta.FxAccrualTriggerMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes a european trigger applied to an FX digtal option.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualTrigger", builder=FxAccrualTrigger.FxAccrualTriggerBuilderImpl.class, version="${project.version}")
public interface FxAccrualTrigger extends FxTriggerBase {

	FxAccrualTriggerMeta metaData = new FxAccrualTriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	List<? extends InformationSource> getInformationSource();
	/**
	 * An anchor to be referenced from the accrual region bound.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	FxAccrualTrigger build();
	
	FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder();
	
	static FxAccrualTrigger.FxAccrualTriggerBuilder builder() {
		return new FxAccrualTrigger.FxAccrualTriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualTrigger> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualTrigger> getType() {
		return FxAccrualTrigger.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualTriggerBuilder extends FxAccrualTrigger, FxTriggerBase.FxTriggerBaseBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index);
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		FxAccrualTrigger.FxAccrualTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerRate(BigDecimal triggerRate);
		FxAccrualTrigger.FxAccrualTriggerBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource0);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource1, int _idx);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(List<? extends InformationSource> informationSource2);
		FxAccrualTrigger.FxAccrualTriggerBuilder setInformationSource(List<? extends InformationSource> informationSource3);
		FxAccrualTrigger.FxAccrualTriggerBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxAccrualTrigger.FxAccrualTriggerBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualTrigger  ***********************/
	class FxAccrualTriggerImpl extends FxTriggerBase.FxTriggerBaseImpl implements FxAccrualTrigger {
		private final List<? extends InformationSource> informationSource;
		private final String id;
		
		protected FxAccrualTriggerImpl(FxAccrualTrigger.FxAccrualTriggerBuilder builder) {
			super(builder);
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxAccrualTrigger build() {
			return this;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder() {
			FxAccrualTrigger.FxAccrualTriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualTrigger.FxAccrualTriggerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTrigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualTrigger {" +
				"informationSource=" + this.informationSource + ", " +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualTrigger  ***********************/
	class FxAccrualTriggerBuilderImpl extends FxTriggerBase.FxTriggerBaseBuilderImpl  implements FxAccrualTrigger.FxAccrualTriggerBuilder {
	
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected String id;
	
		public FxAccrualTriggerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index) {
		
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			InformationSource.InformationSourceBuilder result;
			return getIndex(informationSource, _index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		public FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerCondition(TriggerConditionEnum triggerCondition) {
			this.triggerCondition = triggerCondition==null?null:triggerCondition;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxAccrualTrigger.FxAccrualTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxAccrualTrigger.FxAccrualTriggerBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource) {
			if (informationSource!=null) this.informationSource.add(informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource, int _idx) {
			getIndex(this.informationSource, _idx, () -> informationSource.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualTrigger.FxAccrualTriggerBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null)  {
				this.informationSource = new ArrayList<>();
			}
			else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxAccrualTrigger.FxAccrualTriggerBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxAccrualTrigger build() {
			return new FxAccrualTrigger.FxAccrualTriggerImpl(this);
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder prune() {
			super.prune();
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualTrigger.FxAccrualTriggerBuilder o = (FxAccrualTrigger.FxAccrualTriggerBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTrigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualTriggerBuilder {" +
				"informationSource=" + this.informationSource + ", " +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}
}
