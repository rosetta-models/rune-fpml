package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.validation.WeatherIndexDataTypeFormatValidator;
import fpml.confirmation.validation.WeatherIndexDataValidator;
import fpml.confirmation.validation.exists.WeatherIndexDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherIndexData.class)
public class WeatherIndexDataMeta implements RosettaMetaData<WeatherIndexData> {

	@Override
	public List<Validator<? super WeatherIndexData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherIndexData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherIndexData> validator() {
		return new WeatherIndexDataValidator();
	}

	@Override
	public Validator<? super WeatherIndexData> typeFormatValidator() {
		return new WeatherIndexDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherIndexData, Set<String>> onlyExistsValidator() {
		return new WeatherIndexDataOnlyExistsValidator();
	}
}
