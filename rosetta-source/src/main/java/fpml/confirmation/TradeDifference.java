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
import fpml.confirmation.DifferenceSeverityEnum;
import fpml.confirmation.DifferenceTypeEnum;
import fpml.confirmation.TradeDifference;
import fpml.confirmation.TradeDifference.TradeDifferenceBuilder;
import fpml.confirmation.TradeDifference.TradeDifferenceBuilderImpl;
import fpml.confirmation.TradeDifference.TradeDifferenceImpl;
import fpml.confirmation.meta.TradeDifferenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type used to record the details of a difference between two business objects/
 * @version ${project.version}
 */
@RosettaDataType(value="TradeDifference", builder=TradeDifference.TradeDifferenceBuilderImpl.class, version="${project.version}")
public interface TradeDifference extends RosettaModelObject {

	TradeDifferenceMeta metaData = new TradeDifferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of difference that exists.
	 */
	DifferenceTypeEnum getDifferenceType();
	/**
	 * An indication of the severity of the difference.
	 */
	DifferenceSeverityEnum getDifferenceSeverity();
	/**
	 * The name of the element affected.
	 */
	String getElement();
	/**
	 * XPath to the element in the base object.
	 */
	String getBasePath();
	/**
	 * The value of the element in the base object.
	 */
	String getBaseValue();
	/**
	 * XPath to the element in the other object.
	 */
	String getOtherPath();
	/**
	 * Value of the element in the other trade.
	 */
	String getOtherValue();
	/**
	 * Element(s) that are missing in the other trade.
	 */
	List<String> getMissingElement();
	/**
	 * Element(s) that are extraneous in the other object.
	 */
	List<String> getExtraElement();
	/**
	 * A human readable description of the problem.
	 */
	String getMessage();

	/*********************** Build Methods  ***********************/
	TradeDifference build();
	
	TradeDifference.TradeDifferenceBuilder toBuilder();
	
	static TradeDifference.TradeDifferenceBuilder builder() {
		return new TradeDifference.TradeDifferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeDifference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeDifference> getType() {
		return TradeDifference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("differenceType"), DifferenceTypeEnum.class, getDifferenceType(), this);
		processor.processBasic(path.newSubPath("differenceSeverity"), DifferenceSeverityEnum.class, getDifferenceSeverity(), this);
		processor.processBasic(path.newSubPath("element"), String.class, getElement(), this);
		processor.processBasic(path.newSubPath("basePath"), String.class, getBasePath(), this);
		processor.processBasic(path.newSubPath("baseValue"), String.class, getBaseValue(), this);
		processor.processBasic(path.newSubPath("otherPath"), String.class, getOtherPath(), this);
		processor.processBasic(path.newSubPath("otherValue"), String.class, getOtherValue(), this);
		processor.processBasic(path.newSubPath("missingElement"), String.class, getMissingElement(), this);
		processor.processBasic(path.newSubPath("extraElement"), String.class, getExtraElement(), this);
		processor.processBasic(path.newSubPath("message"), String.class, getMessage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeDifferenceBuilder extends TradeDifference, RosettaModelObjectBuilder {
		TradeDifference.TradeDifferenceBuilder setDifferenceType(DifferenceTypeEnum differenceType);
		TradeDifference.TradeDifferenceBuilder setDifferenceSeverity(DifferenceSeverityEnum differenceSeverity);
		TradeDifference.TradeDifferenceBuilder setElement(String element);
		TradeDifference.TradeDifferenceBuilder setBasePath(String basePath);
		TradeDifference.TradeDifferenceBuilder setBaseValue(String baseValue);
		TradeDifference.TradeDifferenceBuilder setOtherPath(String otherPath);
		TradeDifference.TradeDifferenceBuilder setOtherValue(String otherValue);
		TradeDifference.TradeDifferenceBuilder addMissingElement(String missingElement0);
		TradeDifference.TradeDifferenceBuilder addMissingElement(String missingElement1, int _idx);
		TradeDifference.TradeDifferenceBuilder addMissingElement(List<String> missingElement2);
		TradeDifference.TradeDifferenceBuilder setMissingElement(List<String> missingElement3);
		TradeDifference.TradeDifferenceBuilder addExtraElement(String extraElement0);
		TradeDifference.TradeDifferenceBuilder addExtraElement(String extraElement1, int _idx);
		TradeDifference.TradeDifferenceBuilder addExtraElement(List<String> extraElement2);
		TradeDifference.TradeDifferenceBuilder setExtraElement(List<String> extraElement3);
		TradeDifference.TradeDifferenceBuilder setMessage(String message);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("differenceType"), DifferenceTypeEnum.class, getDifferenceType(), this);
			processor.processBasic(path.newSubPath("differenceSeverity"), DifferenceSeverityEnum.class, getDifferenceSeverity(), this);
			processor.processBasic(path.newSubPath("element"), String.class, getElement(), this);
			processor.processBasic(path.newSubPath("basePath"), String.class, getBasePath(), this);
			processor.processBasic(path.newSubPath("baseValue"), String.class, getBaseValue(), this);
			processor.processBasic(path.newSubPath("otherPath"), String.class, getOtherPath(), this);
			processor.processBasic(path.newSubPath("otherValue"), String.class, getOtherValue(), this);
			processor.processBasic(path.newSubPath("missingElement"), String.class, getMissingElement(), this);
			processor.processBasic(path.newSubPath("extraElement"), String.class, getExtraElement(), this);
			processor.processBasic(path.newSubPath("message"), String.class, getMessage(), this);
		}
		

		TradeDifference.TradeDifferenceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeDifference  ***********************/
	class TradeDifferenceImpl implements TradeDifference {
		private final DifferenceTypeEnum differenceType;
		private final DifferenceSeverityEnum differenceSeverity;
		private final String element;
		private final String basePath;
		private final String baseValue;
		private final String otherPath;
		private final String otherValue;
		private final List<String> missingElement;
		private final List<String> extraElement;
		private final String message;
		
		protected TradeDifferenceImpl(TradeDifference.TradeDifferenceBuilder builder) {
			this.differenceType = builder.getDifferenceType();
			this.differenceSeverity = builder.getDifferenceSeverity();
			this.element = builder.getElement();
			this.basePath = builder.getBasePath();
			this.baseValue = builder.getBaseValue();
			this.otherPath = builder.getOtherPath();
			this.otherValue = builder.getOtherValue();
			this.missingElement = ofNullable(builder.getMissingElement()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.extraElement = ofNullable(builder.getExtraElement()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.message = builder.getMessage();
		}
		
		@Override
		@RosettaAttribute("differenceType")
		public DifferenceTypeEnum getDifferenceType() {
			return differenceType;
		}
		
		@Override
		@RosettaAttribute("differenceSeverity")
		public DifferenceSeverityEnum getDifferenceSeverity() {
			return differenceSeverity;
		}
		
		@Override
		@RosettaAttribute("element")
		public String getElement() {
			return element;
		}
		
		@Override
		@RosettaAttribute("basePath")
		public String getBasePath() {
			return basePath;
		}
		
		@Override
		@RosettaAttribute("baseValue")
		public String getBaseValue() {
			return baseValue;
		}
		
		@Override
		@RosettaAttribute("otherPath")
		public String getOtherPath() {
			return otherPath;
		}
		
		@Override
		@RosettaAttribute("otherValue")
		public String getOtherValue() {
			return otherValue;
		}
		
		@Override
		@RosettaAttribute("missingElement")
		public List<String> getMissingElement() {
			return missingElement;
		}
		
		@Override
		@RosettaAttribute("extraElement")
		public List<String> getExtraElement() {
			return extraElement;
		}
		
		@Override
		@RosettaAttribute("message")
		public String getMessage() {
			return message;
		}
		
		@Override
		public TradeDifference build() {
			return this;
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder toBuilder() {
			TradeDifference.TradeDifferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeDifference.TradeDifferenceBuilder builder) {
			ofNullable(getDifferenceType()).ifPresent(builder::setDifferenceType);
			ofNullable(getDifferenceSeverity()).ifPresent(builder::setDifferenceSeverity);
			ofNullable(getElement()).ifPresent(builder::setElement);
			ofNullable(getBasePath()).ifPresent(builder::setBasePath);
			ofNullable(getBaseValue()).ifPresent(builder::setBaseValue);
			ofNullable(getOtherPath()).ifPresent(builder::setOtherPath);
			ofNullable(getOtherValue()).ifPresent(builder::setOtherValue);
			ofNullable(getMissingElement()).ifPresent(builder::setMissingElement);
			ofNullable(getExtraElement()).ifPresent(builder::setExtraElement);
			ofNullable(getMessage()).ifPresent(builder::setMessage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeDifference _that = getType().cast(o);
		
			if (!Objects.equals(differenceType, _that.getDifferenceType())) return false;
			if (!Objects.equals(differenceSeverity, _that.getDifferenceSeverity())) return false;
			if (!Objects.equals(element, _that.getElement())) return false;
			if (!Objects.equals(basePath, _that.getBasePath())) return false;
			if (!Objects.equals(baseValue, _that.getBaseValue())) return false;
			if (!Objects.equals(otherPath, _that.getOtherPath())) return false;
			if (!Objects.equals(otherValue, _that.getOtherValue())) return false;
			if (!ListEquals.listEquals(missingElement, _that.getMissingElement())) return false;
			if (!ListEquals.listEquals(extraElement, _that.getExtraElement())) return false;
			if (!Objects.equals(message, _that.getMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (differenceType != null ? differenceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (differenceSeverity != null ? differenceSeverity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (element != null ? element.hashCode() : 0);
			_result = 31 * _result + (basePath != null ? basePath.hashCode() : 0);
			_result = 31 * _result + (baseValue != null ? baseValue.hashCode() : 0);
			_result = 31 * _result + (otherPath != null ? otherPath.hashCode() : 0);
			_result = 31 * _result + (otherValue != null ? otherValue.hashCode() : 0);
			_result = 31 * _result + (missingElement != null ? missingElement.hashCode() : 0);
			_result = 31 * _result + (extraElement != null ? extraElement.hashCode() : 0);
			_result = 31 * _result + (message != null ? message.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeDifference {" +
				"differenceType=" + this.differenceType + ", " +
				"differenceSeverity=" + this.differenceSeverity + ", " +
				"element=" + this.element + ", " +
				"basePath=" + this.basePath + ", " +
				"baseValue=" + this.baseValue + ", " +
				"otherPath=" + this.otherPath + ", " +
				"otherValue=" + this.otherValue + ", " +
				"missingElement=" + this.missingElement + ", " +
				"extraElement=" + this.extraElement + ", " +
				"message=" + this.message +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeDifference  ***********************/
	class TradeDifferenceBuilderImpl implements TradeDifference.TradeDifferenceBuilder {
	
		protected DifferenceTypeEnum differenceType;
		protected DifferenceSeverityEnum differenceSeverity;
		protected String element;
		protected String basePath;
		protected String baseValue;
		protected String otherPath;
		protected String otherValue;
		protected List<String> missingElement = new ArrayList<>();
		protected List<String> extraElement = new ArrayList<>();
		protected String message;
	
		public TradeDifferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("differenceType")
		public DifferenceTypeEnum getDifferenceType() {
			return differenceType;
		}
		
		@Override
		@RosettaAttribute("differenceSeverity")
		public DifferenceSeverityEnum getDifferenceSeverity() {
			return differenceSeverity;
		}
		
		@Override
		@RosettaAttribute("element")
		public String getElement() {
			return element;
		}
		
		@Override
		@RosettaAttribute("basePath")
		public String getBasePath() {
			return basePath;
		}
		
		@Override
		@RosettaAttribute("baseValue")
		public String getBaseValue() {
			return baseValue;
		}
		
		@Override
		@RosettaAttribute("otherPath")
		public String getOtherPath() {
			return otherPath;
		}
		
		@Override
		@RosettaAttribute("otherValue")
		public String getOtherValue() {
			return otherValue;
		}
		
		@Override
		@RosettaAttribute("missingElement")
		public List<String> getMissingElement() {
			return missingElement;
		}
		
		@Override
		@RosettaAttribute("extraElement")
		public List<String> getExtraElement() {
			return extraElement;
		}
		
		@Override
		@RosettaAttribute("message")
		public String getMessage() {
			return message;
		}
		
		@Override
		@RosettaAttribute("differenceType")
		public TradeDifference.TradeDifferenceBuilder setDifferenceType(DifferenceTypeEnum differenceType) {
			this.differenceType = differenceType==null?null:differenceType;
			return this;
		}
		@Override
		@RosettaAttribute("differenceSeverity")
		public TradeDifference.TradeDifferenceBuilder setDifferenceSeverity(DifferenceSeverityEnum differenceSeverity) {
			this.differenceSeverity = differenceSeverity==null?null:differenceSeverity;
			return this;
		}
		@Override
		@RosettaAttribute("element")
		public TradeDifference.TradeDifferenceBuilder setElement(String element) {
			this.element = element==null?null:element;
			return this;
		}
		@Override
		@RosettaAttribute("basePath")
		public TradeDifference.TradeDifferenceBuilder setBasePath(String basePath) {
			this.basePath = basePath==null?null:basePath;
			return this;
		}
		@Override
		@RosettaAttribute("baseValue")
		public TradeDifference.TradeDifferenceBuilder setBaseValue(String baseValue) {
			this.baseValue = baseValue==null?null:baseValue;
			return this;
		}
		@Override
		@RosettaAttribute("otherPath")
		public TradeDifference.TradeDifferenceBuilder setOtherPath(String otherPath) {
			this.otherPath = otherPath==null?null:otherPath;
			return this;
		}
		@Override
		@RosettaAttribute("otherValue")
		public TradeDifference.TradeDifferenceBuilder setOtherValue(String otherValue) {
			this.otherValue = otherValue==null?null:otherValue;
			return this;
		}
		@Override
		@RosettaAttribute("missingElement")
		public TradeDifference.TradeDifferenceBuilder addMissingElement(String missingElement) {
			if (missingElement!=null) this.missingElement.add(missingElement);
			return this;
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder addMissingElement(String missingElement, int _idx) {
			getIndex(this.missingElement, _idx, () -> missingElement);
			return this;
		}
		@Override 
		public TradeDifference.TradeDifferenceBuilder addMissingElement(List<String> missingElements) {
			if (missingElements != null) {
				for (String toAdd : missingElements) {
					this.missingElement.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public TradeDifference.TradeDifferenceBuilder setMissingElement(List<String> missingElements) {
			if (missingElements == null)  {
				this.missingElement = new ArrayList<>();
			}
			else {
				this.missingElement = missingElements.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("extraElement")
		public TradeDifference.TradeDifferenceBuilder addExtraElement(String extraElement) {
			if (extraElement!=null) this.extraElement.add(extraElement);
			return this;
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder addExtraElement(String extraElement, int _idx) {
			getIndex(this.extraElement, _idx, () -> extraElement);
			return this;
		}
		@Override 
		public TradeDifference.TradeDifferenceBuilder addExtraElement(List<String> extraElements) {
			if (extraElements != null) {
				for (String toAdd : extraElements) {
					this.extraElement.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public TradeDifference.TradeDifferenceBuilder setExtraElement(List<String> extraElements) {
			if (extraElements == null)  {
				this.extraElement = new ArrayList<>();
			}
			else {
				this.extraElement = extraElements.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("message")
		public TradeDifference.TradeDifferenceBuilder setMessage(String message) {
			this.message = message==null?null:message;
			return this;
		}
		
		@Override
		public TradeDifference build() {
			return new TradeDifference.TradeDifferenceImpl(this);
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeDifference.TradeDifferenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDifferenceType()!=null) return true;
			if (getDifferenceSeverity()!=null) return true;
			if (getElement()!=null) return true;
			if (getBasePath()!=null) return true;
			if (getBaseValue()!=null) return true;
			if (getOtherPath()!=null) return true;
			if (getOtherValue()!=null) return true;
			if (getMissingElement()!=null && !getMissingElement().isEmpty()) return true;
			if (getExtraElement()!=null && !getExtraElement().isEmpty()) return true;
			if (getMessage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeDifference.TradeDifferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeDifference.TradeDifferenceBuilder o = (TradeDifference.TradeDifferenceBuilder) other;
			
			
			merger.mergeBasic(getDifferenceType(), o.getDifferenceType(), this::setDifferenceType);
			merger.mergeBasic(getDifferenceSeverity(), o.getDifferenceSeverity(), this::setDifferenceSeverity);
			merger.mergeBasic(getElement(), o.getElement(), this::setElement);
			merger.mergeBasic(getBasePath(), o.getBasePath(), this::setBasePath);
			merger.mergeBasic(getBaseValue(), o.getBaseValue(), this::setBaseValue);
			merger.mergeBasic(getOtherPath(), o.getOtherPath(), this::setOtherPath);
			merger.mergeBasic(getOtherValue(), o.getOtherValue(), this::setOtherValue);
			merger.mergeBasic(getMissingElement(), o.getMissingElement(), (Consumer<String>) this::addMissingElement);
			merger.mergeBasic(getExtraElement(), o.getExtraElement(), (Consumer<String>) this::addExtraElement);
			merger.mergeBasic(getMessage(), o.getMessage(), this::setMessage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeDifference _that = getType().cast(o);
		
			if (!Objects.equals(differenceType, _that.getDifferenceType())) return false;
			if (!Objects.equals(differenceSeverity, _that.getDifferenceSeverity())) return false;
			if (!Objects.equals(element, _that.getElement())) return false;
			if (!Objects.equals(basePath, _that.getBasePath())) return false;
			if (!Objects.equals(baseValue, _that.getBaseValue())) return false;
			if (!Objects.equals(otherPath, _that.getOtherPath())) return false;
			if (!Objects.equals(otherValue, _that.getOtherValue())) return false;
			if (!ListEquals.listEquals(missingElement, _that.getMissingElement())) return false;
			if (!ListEquals.listEquals(extraElement, _that.getExtraElement())) return false;
			if (!Objects.equals(message, _that.getMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (differenceType != null ? differenceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (differenceSeverity != null ? differenceSeverity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (element != null ? element.hashCode() : 0);
			_result = 31 * _result + (basePath != null ? basePath.hashCode() : 0);
			_result = 31 * _result + (baseValue != null ? baseValue.hashCode() : 0);
			_result = 31 * _result + (otherPath != null ? otherPath.hashCode() : 0);
			_result = 31 * _result + (otherValue != null ? otherValue.hashCode() : 0);
			_result = 31 * _result + (missingElement != null ? missingElement.hashCode() : 0);
			_result = 31 * _result + (extraElement != null ? extraElement.hashCode() : 0);
			_result = 31 * _result + (message != null ? message.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeDifferenceBuilder {" +
				"differenceType=" + this.differenceType + ", " +
				"differenceSeverity=" + this.differenceSeverity + ", " +
				"element=" + this.element + ", " +
				"basePath=" + this.basePath + ", " +
				"baseValue=" + this.baseValue + ", " +
				"otherPath=" + this.otherPath + ", " +
				"otherValue=" + this.otherValue + ", " +
				"missingElement=" + this.missingElement + ", " +
				"extraElement=" + this.extraElement + ", " +
				"message=" + this.message +
			'}';
		}
	}
}
